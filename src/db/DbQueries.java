/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import entities.ContractorEntity;
import entities.DocEntity;
import entities.DocProductEntity;
import entities.ProductEntity;
import entities.groupEntity;
import entities.unitEntity;
import entities.vatEntity;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;
import utilities.TimeFunctions;

/**
 *
 * @author Marek
 */
public class DbQueries {
    public DbConnect conn = new DbConnect();
    public TimeFunctions tm = new TimeFunctions();
    
    //WITHDRAW PRODUCT
    
    public void withdrawUnwithdraw(int id, int status){
        conn.connect();
        try{
            conn.stmt = (PreparedStatement) conn.connection.prepareStatement(
                    "UPDATE product_tab SET product_status=? WHERE product_id=?"
        );
        conn.stmt.setInt(1, status);
        conn.stmt.setInt(2, id);
        
        int rowInserted = conn.stmt.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    //GET LIST OF GROUPS FROM DB
    public List<groupEntity> getGroups(){
        List<groupEntity> ans = new ArrayList<>();
        int id;
        String name;
        String nameShort;
        conn.connect();
        try{
            conn.stmt = (PreparedStatement) conn.connection.prepareStatement(
                    "SELECT * FROM product_group_tab"
            );
            conn.result = conn.stmt.executeQuery();
            while(conn.result.next()){
                id = conn.result.getInt("product_group_id");
                name = conn.result.getString("product_group_name");
                nameShort = conn.result.getString("product_group_short");
                ans.add(new groupEntity(id,name,nameShort));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }        
        conn.disconnect();
        return ans;
    }
    
    //ADD PRODUCT
    public void addProduct(String name, int producerId, float price, String group, int vat, String ean, String unit){
        conn.connect();
        int groupId=0;
        int vatId=0;
        int unitId=0;
        
        //----
        try{
            conn.stmt = (PreparedStatement) conn.connection.prepareStatement(
                    "SELECT product_group_id FROM product_group_tab WHERE product_group_name=?"
            );
            conn.stmt.setString(1, group);
            conn.result = conn.stmt.executeQuery();
            conn.result.last();
            groupId= conn.result.getInt("product_group_id");
        }catch(Exception e){
            e.printStackTrace();
        }
        //----
        try{
            conn.stmt = (PreparedStatement) conn.connection.prepareStatement(
                    "SELECT vat_id FROM vat_tab WHERE vat_value=?"
            );
            conn.stmt.setInt(1, vat);
            conn.result = conn.stmt.executeQuery();
            conn.result.last();
            vatId= conn.result.getInt("vat_id");
        }catch(Exception e){
            e.printStackTrace();
        }
        
        //----
        try{
            conn.stmt = (PreparedStatement) conn.connection.prepareStatement(
                    "SELECT product_unit_id FROM product_unit_tab WHERE product_unit_name=?"
            );
            conn.stmt.setString(1, unit);
            conn.result = conn.stmt.executeQuery();
            conn.result.last();
            unitId= conn.result.getInt("product_unit_id");
        }catch(Exception e){
            e.printStackTrace();
        }
        
        try{
            conn.stmt = (PreparedStatement) conn.connection.prepareStatement(
                    "insert into product_tab (product_name, product_producer, product_number, product_price, product_vat, product_last_price, product_ean, product_group, product_status, product_unit) "
                            + "values (?,?,0,?,?,0,?,?,1,?)"
        );
      conn.stmt.setString(1, name);
      conn.stmt.setInt(2, producerId);
      conn.stmt.setFloat(3, price);
      conn.stmt.setInt(4, vatId);
      conn.stmt.setString(5, ean);
      conn.stmt.setInt(6, groupId);
      conn.stmt.setInt(7, unitId);
        
        int rowInserted = conn.stmt.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    } 
    
    //GET LIST OF VATS FROM DB
    public List<vatEntity> getVat(){
        List<vatEntity> ans = new ArrayList<>();
        int id;
        int value;
        conn.connect();
        try{
            conn.stmt = (PreparedStatement) conn.connection.prepareStatement(
                    "SELECT * FROM vat_tab"
            );
            conn.result = conn.stmt.executeQuery();
            while(conn.result.next()){
                id = conn.result.getInt("vat_id");
                value = conn.result.getInt("vat_value");
                ans.add(new vatEntity(id,value));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }        
        conn.disconnect();
        return ans;
    }
    
    //GET LIST OF UNITS FROM DB
    public List<unitEntity> getUnits(){
        List<unitEntity> ans = new ArrayList<>();
        int id;
        String name;
        String nameShort;
        conn.connect();
        try{
            conn.stmt = (PreparedStatement) conn.connection.prepareStatement(
                    "SELECT * FROM product_unit_tab"
            );
            conn.result = conn.stmt.executeQuery();
            while(conn.result.next()){
                id = conn.result.getInt("product_unit_id");
                name = conn.result.getString("product_unit_name");
                nameShort = conn.result.getString("product_unit_short");
                ans.add(new unitEntity(id, name, nameShort));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }        
        conn.disconnect();
        return ans;
    }    
    
    //LOOKING FOR CONTRACTOR
    
    public List<ContractorEntity> findContracor(String namePart, String nipPart, boolean IsProvider){
       List<ContractorEntity> resultList = new ArrayList<>();
       int id, provider;
       String name, city, street, nip, postalCode, country;
       
       conn.connect();
       try{
            if(IsProvider == false){
                conn.stmt = (PreparedStatement) conn.connection.prepareStatement("SELECT * FROM contractor_tab WHERE contractor_name LIKE ? AND replace(contractor_nip,'-','') LIKE ?");
            }else{
                conn.stmt = (PreparedStatement) conn.connection.prepareStatement("SELECT * FROM contractor_tab WHERE contractor_name LIKE ? AND replace(contractor_nip,'-','') LIKE ? AND contractor_provider=1");
            }
            conn.stmt.setString(1, '%'+namePart+'%');
            conn.stmt.setString(2, '%'+nipPart+'%');
            conn.result = conn.stmt.executeQuery();
            while(conn.result.next()){
                id = conn.result.getInt("contractor_id");
                name = conn.result.getString("contractor_name");
                nip = conn.result.getString("contractor_nip");
                postalCode = conn.result.getString("contractor_postal_code");
                city = conn.result.getString("contractor_city");
                street = conn.result.getString("contractor_street");
                country = conn.result.getString("contractor_country");
                provider = conn.result.getInt("contractor_provider");
                resultList.add(new ContractorEntity(id, name, nip, postalCode, city, street, country, provider));
            }
        }
       catch(Exception e){
           e.printStackTrace();
       }
       return resultList;
    }
    
    //GET DOCUMENT LIST
    public List<DocEntity> getWZDocs(){
        List<DocEntity> resultList = new ArrayList<>();
        int id, docNumber, docYear, docType, docContractorId;
        Timestamp docDate, docAcceptDate;
        String docContractorName;
        conn.connect();
        try{
            conn.stmt = (PreparedStatement) conn.connection.prepareStatement(
                    "SELECT document_id, document_date, document_accept_date, document_year, document_number, document_type"
                            + ", document_contractor_id, contractor_name FROM document_tab"
                            + " inner join contractor_tab on document_tab.document_contractor_id=contractor_tab.contractor_id"
                            + " where document_type=1 and document_number = 0 order by document_id desc"
            );
            conn.result = conn.stmt.executeQuery();
                        
            while(conn.result.next()){
                id = conn.result.getInt("document_id");
                docNumber = conn.result.getInt("document_number");
                docYear = conn.result.getInt("document_year");
                docType = conn.result.getInt("document_type");
                docDate = tm.longToTimestamp(conn.result.getLong("document_date"));
                docAcceptDate = tm.longToTimestamp(conn.result.getLong("document_accept_date"));
                docContractorName = conn.result.getString("contractor_name");
                docContractorId = conn.result.getInt("document_contractor_id");
                resultList.add(new DocEntity(id, docNumber, docYear, docType, docDate, docAcceptDate, docContractorName, docContractorId));
            }
            conn.stmt = (PreparedStatement) conn.connection.prepareStatement(
                    "SELECT document_id, document_date, document_accept_date, document_year, document_number, document_type"
                            + ", document_contractor_id, contractor_name FROM document_tab"
                            + " inner join contractor_tab on document_tab.document_contractor_id=contractor_tab.contractor_id"
                            + " where document_type=1 and document_number <> 0 order by document_number desc limit 30"
            );
            conn.result = conn.stmt.executeQuery();
                        
            while(conn.result.next()){
                id = conn.result.getInt("document_id");
                docNumber = conn.result.getInt("document_number");
                docYear = conn.result.getInt("document_year");
                docType = conn.result.getInt("document_type");
                docDate = tm.longToTimestamp(conn.result.getLong("document_date"));
                docAcceptDate = tm.longToTimestamp(conn.result.getLong("document_accept_date"));
                docContractorName = conn.result.getString("contractor_name");
                docContractorId = conn.result.getInt("document_contractor_id");
                resultList.add(new DocEntity(id, docNumber, docYear, docType, docDate, docAcceptDate, docContractorName, docContractorId));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }        
        conn.disconnect();
        return resultList;
    }
    
    //POBIERZ OSTATNI DOKUMENT WZ
    public DocEntity getLastWZ(){
        int id = 0, docNumber = 0, docYear = 0, docType = 0, docContractorId = 0;
        Timestamp docDate = Timestamp.valueOf("1970-01-01 00:00:00.0"), docAcceptDate = Timestamp.valueOf("1970-01-01 00:00:00.0");
        String docContractorName = "";
        DocEntity result;
        result = new DocEntity(id, docNumber, docYear, docType, docDate, docAcceptDate, docContractorName, docContractorId);
        conn.connect();
        try{
            conn.stmt = (PreparedStatement) conn.connection.prepareStatement(
                    "select * from document_tab where document_type=1 order by document_id desc limit 1"
            );
            conn.result = conn.stmt.executeQuery();
            while(conn.result.next()){
                id = conn.result.getInt("document_id");
                docNumber = conn.result.getInt("document_number");
                docYear = conn.result.getInt("document_year");
                docType = conn.result.getInt("document_type");
                docDate = tm.longToTimestamp(conn.result.getLong("document_date"));
                docAcceptDate = tm.longToTimestamp(conn.result.getLong("document_accept_date"));
                docContractorId = conn.result.getInt("document_contractor_id");
                result = new DocEntity(id, docNumber, docYear, docType, docDate, docAcceptDate, docContractorName, docContractorId);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
    //ADD DOCUMENT
    public void addDoc(int docType, long docDate, long docAcceptDate, int contractorId, int DocNumber, int docYear){
        conn.connect();
        try{
            conn.stmt = (PreparedStatement) conn.connection.prepareStatement(
                    "insert into document_tab (document_type, document_date, document_accept_date, document_contractor_id, document_number, document_year) "
                            + "values (?,?,?,?,?,?)"
        );
        conn.stmt.setInt(1, docType);
        conn.stmt.setLong(2, docDate);
        conn.stmt.setLong(3, docAcceptDate);
        conn.stmt.setInt(4, contractorId);
        conn.stmt.setInt(5, DocNumber);
        conn.stmt.setInt(6, docYear);
        
        int rowInserted = conn.stmt.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //DELETE DOCUMENT
    public void delDoc(int docId){
        conn.connect();
        try{
            conn.stmt = (PreparedStatement) conn.connection.prepareStatement(
                    "delete from document_tab where document_id=?"
        );
        conn.stmt.setInt(1, docId);
        
        int rowInserted = conn.stmt.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    
    //GET PRODUCT LIST

    public List<ProductEntity> getProducts(){
        List<ProductEntity> resultList = new ArrayList<>();       
        
        int id = 0, vat = 0;
        String name = "", contractor = "", status = "", unit = "", group = "";
        float number = 0, price = 0;
                
        conn.connect();
        try{
            conn.stmt = (PreparedStatement) conn.connection.prepareStatement(
                "SELECT product_id, product_name, contractor_name, product_number, product_price, vat_value, product_status_name, product_group_name, product_unit_short FROM product_tab"
                       +" join contractor_tab on product_tab.product_producer = contractor_tab.contractor_id"
                       +" join vat_tab on product_tab.product_vat = vat_tab.vat_id"
                       +" join product_group_tab on product_tab.product_group = product_group_tab.product_group_id"
                       +" join product_status_tab on product_status_tab.product_status_id = product_tab.product_status"
                       +" join product_unit_tab on product_tab.product_unit = product_unit_tab.product_unit_id order by product_id"
            );
       
            conn.result = conn.stmt.executeQuery();
                        
            while(conn.result.next()){
                id = conn.result.getInt("product_id");
                name = conn.result.getString("product_name");
                contractor = conn.result.getString("contractor_name");
                number = conn.result.getFloat("product_number");
                price = conn.result.getFloat("product_price");
                vat = conn.result.getInt("vat_value");
                status = conn.result.getString("product_status_name");
                group = conn.result.getString("product_group_name");
                unit = conn.result.getString("product_unit_short");
                resultList.add(new ProductEntity(id, name, contractor, number, price, vat, group, status, unit));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return resultList;
    }
    
    //GET PRODUCTS ON DOCUMENT
    public List<DocProductEntity> getDocProducts(int docId){
        List<DocProductEntity> resultList = new ArrayList<>();
        int id = 0;
        String name = "";
        float price = 0;
        int vat = 0;
        String unit;
        float number;
        conn.connect();
        try{
            conn.stmt = (PreparedStatement) conn.connection.prepareStatement(
                    "SELECT product_id, product_name, product_price, vat_value, product_unit_short, document_rekords_product_number FROM document_rekords"
                        +" inner join product_tab on product_tab.product_id = document_rekords.document_rekords_product_id"
                        +" inner join product_unit_tab on product_unit_tab.product_unit_id = product_tab.product_unit"
                        +" inner join vat_tab on vat_tab.vat_id = product_tab.product_vat"
                        +" where document_rekords_document_id=?"
            );
            conn.stmt.setInt(1, docId);
            conn.result = conn.stmt.executeQuery();
                        
            while(conn.result.next()){
                id = conn.result.getInt("product_id");
                name = conn.result.getString("product_name");
                price = conn.result.getFloat("product_price");
                vat = conn.result.getInt("vat_value");
                unit = conn.result.getString("product_unit_short");
                number = conn.result.getFloat("document_rekords_product_number");
                resultList.add(new DocProductEntity(id, name, price, vat, unit, number));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return resultList;
    }
    
}

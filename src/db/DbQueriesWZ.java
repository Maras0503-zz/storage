/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import entities.DocEntity;
import entities.DocProductEntity;
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
public class DbQueriesWZ {
    public DbConnect conn = new DbConnect();
    public TimeFunctions tm = new TimeFunctions();
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
                            + " where document_type=1 order by document_number desc"
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

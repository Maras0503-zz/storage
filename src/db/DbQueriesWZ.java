/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import entities.DocEntity;
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
    public List<DocEntity> getWZDocs(){
        List<DocEntity> resultList = new ArrayList<>();
        int id, docNumber, docYear, docType, docContractorId;
        Timestamp docDate;
        String docContractorName;
        conn.connect();
        try{
            conn.stmt = (PreparedStatement) conn.connection.prepareStatement(
                    "SELECT document_id, document_date, document_year, document_number, document_type"
                            + ", document_contractor_id, contractor_name FROM document_tab"
                            + " inner join contractor_tab on document_tab.document_contractor_id=contractor_tab.contractor_id"
                            + " where document_type=1"
            );
            conn.result = conn.stmt.executeQuery();
                        
            while(conn.result.next()){
                id = conn.result.getInt("document_id");
                docNumber = conn.result.getInt("document_number");
                docYear = conn.result.getInt("document_year");
                docType = conn.result.getInt("document_type");
                docDate = tm.longToTimestamp(conn.result.getLong("document_date"));
                docContractorName = conn.result.getString("contractor_name");
                docContractorId = conn.result.getInt("document_contractor_id");
                resultList.add(new DocEntity(id, docNumber, docYear, docType, docDate, docContractorName, docContractorId));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }        
        conn.disconnect();
        return resultList;
    }
    
}

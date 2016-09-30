/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Timestamp;
/**
 *
 * @author Marek
 */
public class DocEntity {
    int id;

    public DocEntity(int id, int docNumber, int docYear, int docType, Timestamp docDate, Timestamp docAcceptDate, String docContractorName, int docContractorId) {
        this.id = id;
        this.docNumber = docNumber;
        this.docYear = docYear;
        this.docType = docType;
        this.docDate = docDate;
        this.docAcceptDate = docAcceptDate;
        this.docContractorName = docContractorName;
        this.docContractorId = docContractorId;
    }
    int docNumber;
    int docYear;
    int docType;
    Timestamp docDate;
    Timestamp docAcceptDate;
    String docContractorName;
    int docContractorId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getDocAcceptDate() {
        return docAcceptDate;
    }

    public void setDocAcceptDate(Timestamp docAcceptDate) {
        this.docAcceptDate = docAcceptDate;
    }

    public int getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(int docNumber) {
        this.docNumber = docNumber;
    }

    public int getDocYear() {
        return docYear;
    }

    public void setDocYear(int docYear) {
        this.docYear = docYear;
    }

    public int getDocType() {
        return docType;
    }

    public void setDocType(int docType) {
        this.docType = docType;
    }

    public Timestamp getDocDate() {
        return docDate;
    }

    public void setDocDate(Timestamp docDate) {
        this.docDate = docDate;
    }

    public String getDocContractorName() {
        return docContractorName;
    }

    public void setDocContractorName(String docContractorName) {
        this.docContractorName = docContractorName;
    }

    public int getDocContractorId() {
        return docContractorId;
    }

    public void setDocContractorId(int docContractorId) {
        this.docContractorId = docContractorId;
    }
    
}

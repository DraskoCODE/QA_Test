package models;

import java.util.List;

public class Table {

    //private List<Row> rows;
    private List<List<String>> rows;

    //public Table(List<Row> rows) {
        //this.rows = rows;
    //}

    public Table(List<List<String>> rows) {
        this.rows = rows;
    }

    public List<List<String>> getRows() {
        return rows;
    }

    public void setRows(List<List<String>> rows) {
        this.rows = rows;
    }

    //public Row returnRowAtPosition(int rowNumber) {
        //return rows.get(rowNumber);
    //}

    public List<String> returnRowAtPosition(int rowNumber) {
        return rows.get(rowNumber);
    }
}

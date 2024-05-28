package com.example.collab.services;

import java.util.List;

public class CompanyResponse {
    private List<Companies> results;

    public List<Companies> getResults(){
        return results;
    }

    public void setResults(List<Companies> results) {
        this.results = results;
    }
}

 class Companies {
    private String name;
    private String incorporation_date;
    private String registered_address;
    private String company_number;
}

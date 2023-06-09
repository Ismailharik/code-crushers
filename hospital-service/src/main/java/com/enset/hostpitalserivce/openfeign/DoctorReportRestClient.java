package com.enset.hostpitalserivce.openfeign;

import com.enset.hostpitalserivce.entities.DoctorReport;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "hospital-service", url = "http://localhost:3000")
public interface DoctorReportRestClient {
//    @Retry(name = "patients-service")

    @PostMapping("/store")
    public Object postReportToBlockChain(@RequestBody DoctorReport doctorReport);

    //this method will make request to node-service to get the history of block Chain of the actual user
    @GetMapping("/get/{patientChain}")
    public Object getPatientHistory(@PathVariable String patientChain);
}

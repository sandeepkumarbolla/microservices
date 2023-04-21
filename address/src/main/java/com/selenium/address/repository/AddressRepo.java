package com.selenium.address.repository;

import com.selenium.address.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AddressRepo extends JpaRepository<Address,Integer> {


    @Query(nativeQuery = true,
            value = "select ea.id,ea.lane1,ea.lane2,ea.state,ea.zip from sample.address ea " +
                    "join sample.employee e on e.id = ea.employee_id " +
                    "where ea.employee_id=:employee_id")
    Address findAddressByEmployeeId(int employee_id);
}

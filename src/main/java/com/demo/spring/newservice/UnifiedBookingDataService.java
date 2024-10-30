 
package com.demo.spring.newservice;

import com.demo.spring.dto.DataProjectionDto;
import com.demo.spring.model.UnifiedBookingData;
import com.demo.spring.repository.UnifiedBookingDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnifiedBookingDataService {

    @Autowired
    private UnifiedBookingDataRepository unifiedBookingDataRepository;

    @Autowired
    private HdfsService hdfsService;


    public void insertCombinedBookingData() {
        List<DataProjectionDto> results = unifiedBookingDataRepository.fetchCombinedBookingData();
        System.out.println("Number of records to process: " + results.size());

        for (DataProjectionDto dto : results) {
            UnifiedBookingData unifiedBookingData = new UnifiedBookingData();
            unifiedBookingData.setBookingId(dto.getBookingId());
            unifiedBookingData.setUuid(dto.getSummaryUuid());
            unifiedBookingData.setCheckin(dto.getCheckIn());
            unifiedBookingData.setCheckout(dto.getCheckOut());
            unifiedBookingData.setGrandTotal(dto.getGrandTotal());
            unifiedBookingData.setCorporateId(
                    dto.getCorporateId() != null ? dto.getCorporateId() : "Default Corporate ID");
            unifiedBookingData.setComparisonPrice(
                    dto.getComparisonPrice() != null ? dto.getComparisonPrice() : 0.0);
            unifiedBookingData.setLocalCurrency(
                    dto.getLocalCurrency() != null ? dto.getLocalCurrency() : "Default Currency");
            unifiedBookingData.setLocalCurrencyAmount(
                    dto.getLocalCurrencyAmount() != null ? dto.getLocalCurrencyAmount() : 0.0f);
            unifiedBookingData.setNoShowReason(
                    dto.getNoShowReason() != null ? dto.getNoShowReason() : "No Reason Provided");
            unifiedBookingData.setTravellerName(
                    dto.getTravellerName() != null ? dto.getTravellerName() : "Unknown");

            // Save data in the database
            unifiedBookingDataRepository.save(unifiedBookingData);
            String hdfsPath = "/opt/homebrew/opt/hadoop" + dto.getBookingId();
            hdfsService.writeToHdfs(hdfsPath, unifiedBookingData.toString());

        }
    }
}


/*
package com.demo.spring.validator;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class QueryValidator {

    private static final List<String> approvedQueries = Arrays.asList(
            "SELECT * FROM booking_data_hudi",
            "SELECT * FROM unified_booking_data"
    );

    public boolean isValidQuery(String query) {
        return approvedQueries.stream().anyMatch(query::contains);
    }
}
*/


/*
package com.demo.spring.validator;

import org.springframework.stereotype.Component;
import java.util.Arrays;
import java.util.List;

@Component
public class QueryValidator {

    private static final List<String> approvedQueries = Arrays.asList(
            "SELECT * FROM unified_booking_data",
            "SELECT * FROM booking_data_hudi"
    );

    private static final List<String> approvedTables = Arrays.asList(
            "unified_booking_data",
            "booking_data_hudi"
    );

    public boolean isValidQuery(String query) {
        return approvedQueries.stream().anyMatch(query::contains);
    }

    public boolean isValidTable(String tableName) {
        return approvedTables.contains(tableName);
    }
}

*/


package com.demo.spring.validator;

import org.springframework.stereotype.Component;
import java.util.Arrays;
import java.util.List;

@Component
public class QueryValidator {

    private static final List<String> approvedQueries = Arrays.asList(
            "SELECT * FROM dfs.hudi.`unified_booking_data`",
            "SELECT * FROM dfs.hudi.`booking_data_hudi`"
    );

    public boolean isValidQuery(String query) {
        return approvedQueries.stream().anyMatch(query::contains);
    }
}


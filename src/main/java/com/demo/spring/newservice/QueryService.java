/*
package com.demo.spring.newservice;
import java.util.List;
import java.util.Map;

public interface QueryService {
    List<Map<String, Object>> executeQuery(String query);

    List<Map<String, Object>> executeQuery(String tableName, String bookingId);
}

*/


package com.demo.spring.newservice;

import java.util.List;
import java.util.Map;

public interface QueryService {
    String executeQuery(String query);

    List<Map<String, Object>> executeQuery(String tableName, String bookingId);
}

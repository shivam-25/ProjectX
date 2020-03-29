package alphavantage;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class AlphaVantageApi {
    private final CloseableHttpClient httpClient = HttpClients.createDefault();
    //private static final String API_KEY = "XNMS8GH3E7M4PRWD";
    private static final String BASE_URL = "https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&interval=1min&symbol=%s&apikey=";

    private static final String[] SYM_LIST = {"MSFT", "GOOG", "TM", "BAC", "VOD"};


    public HttpEntity getSymListData(String symbol, String api_key) throws IOException {
        HttpGet request = new HttpGet(String.format(BASE_URL+api_key, symbol));
        // add request headers
        CloseableHttpResponse response = httpClient.execute(request);
        // Get HttpResponse Status
        System.out.println(response.getStatusLine().toString());

        HttpEntity entity = response.getEntity();
        Header headers = entity.getContentType();
        System.out.println(headers);

        return entity;


    }

    public List<Map<String, String>> getStoredSymbolResults(String api_key) throws IOException, ParseException {
        
        ArrayList<Map<String, String>> returnObj =new ArrayList<>();
        Map<String, Map<String,Object>> map = new HashMap<String, Map<String,Object>>();
        for (String sym : SYM_LIST) {
        	JSONParser jsonParser = new JSONParser();
        	Map<String, String> retMap = new HashMap<>();
            HttpEntity entity = getSymListData(sym, api_key);
            JSONObject jsonObject = (JSONObject) jsonParser.parse(
                    new InputStreamReader(entity.getContent(), "UTF-8"));
            System.out.println("----------------"+sym+"----------------");
            retMap.put("symbol", sym);
            int i=0;
            JSONObject jsonObject2 = (JSONObject)jsonObject.get("Time Series (1min)");
            for(Iterator iterator = ((JSONObject)jsonObject.get("Time Series (1min)")).keySet().iterator(); iterator.hasNext();) {
                i++;               
                System.out.println("----------------"+iterator.next()+"----------------");
                JSONObject jsonObject3 = (JSONObject) jsonObject2.get(iterator.next());
            	System.out.println("----------------"+jsonObject3+"----------------");
                String value1 = (String)jsonObject3.get("4. close");
                retMap.put(("C"+i), value1);
                String value2 = (String)jsonObject3.get("5. volume");
                retMap.put(("V"+i), value2);
            
                if(i==5)
                	break;
            }
            returnObj.add(retMap);


        }
        System.out.println(returnObj);
        return returnObj;


    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsontutorial;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 *
 * @author maxio
 */
public class UE02 {
    Gson gson1 = new Gson();
    
    Gson gson = new GsonBuilder()
                  .disableHtmlEscaping()
                  .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                  .setPrettyPrinting()
                  .serializeNulls()
                  .create();
}

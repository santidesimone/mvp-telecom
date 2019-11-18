package org.telecom.infinispan.cache.solution;

import org.infinispan.Cache;
import org.infinispan.configuration.cache.ConfigurationBuilder;
import org.infinispan.manager.DefaultCacheManager;
import org.infinispan.manager.EmbeddedCacheManager;



import static java.util.concurrent.TimeUnit.SECONDS;
import static org.telecom.infinispan.cache.solution.util.Assert.assertEqual;
import static org.telecom.infinispan.cache.solution.util.Assert.assertFalse;
import static org.telecom.infinispan.cache.solution.util.Assert.assertTrue;


import static org.infinispan.eviction.EvictionStrategy.LIRS;
public class Application {
   public static void main(String args[]) throws Exception {
      EmbeddedCacheManager manager = new DefaultCacheManager();
      manager.defineConfiguration("custom-cache", new ConfigurationBuilder()
            .eviction().strategy(LIRS).maxEntries(10)
            .build());
      Cache<Object, Object> cache = manager.getCache("custom-cache");

      System.out.println("");
      System.out.println("Add a entry");
      cache.put("key", "value");
      System.out.println("added 'key' as the key, and 'value' as the value for this entry");
      System.out.println("--------------------------------------");
      System.out.println("");

      System.out.println("Validate the entry is now in the cache");
      assertEqual(1, cache.size());
      System.out.println("cache.size() is: " + cache.size() );
      assertTrue(cache.containsKey("key"));
      System.out.println("--------------------------------------");
      System.out.println("");



      System.out.println("Remove the entry from the cache");
      Object v = cache.remove("key");
      System.out.println("--------------------------------------");
      System.out.println("");


      System.out.println("Validate the entry is no longer in the cache");
      assertEqual("value", v);
      assertTrue(cache.isEmpty());
      System.out.println("cache.isEmpty() results in : " + cache.isEmpty() );
      System.out.println("--------------------------------------");
      System.out.println("");



      System.out.println("Add an entry with the key 'key'");
      cache.put("key", "value");
      System.out.println("And replace its value only if the key missing");
      cache.putIfAbsent("key", "newValue");
      System.out.println("Validate that the new value was not added");
      assertEqual("value", cache.get("key"));
      System.out.println("cache.get('key') = " + cache.get("key") );
      System.out.println("--------------------------------------");
      System.out.println("");


      cache.clear();
      assertTrue(cache.isEmpty());

      
      System.out.println("cache.clear() was executed");
      cache.clear();
      assertTrue(cache.isEmpty());
      System.out.println("cache.isEmpty() results in : " + cache.isEmpty() );
      System.out.println("--------------------------------------");
      System.out.println("")


      //By default entries are immortal but we can override this on a per-key basis and provide lifespans.
      cache.put("key", "value", 5, SECONDS);
      assertTrue(cache.containsKey("key"));
      Thread.sleep(10000);
      assertFalse(cache.containsKey("key"));
      
   }

}


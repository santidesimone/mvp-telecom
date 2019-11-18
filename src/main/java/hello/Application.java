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


// import org.infinispan.query.Search;
// import org.infinispan.query.SearchManager;
// import org.apache.lucene.search.Query;

// import org.infinispan.query.CacheQuery;

// For searches that do not require Lucene or full-text capabilities 
// and are mostly about aggregation and exact matches, 
// we can use the Infinispan Query DSL API:
// import org.infinispan.query.Search;
// import org.infinispan.query.dsl.QueryFactory;
// import org.infinispan.query.dsl.Query;

import java.util.List; 

// import org.infinispan.query.Search;
// import org.infinispan.query.dsl.*;

import org.infinispan.query.Search;
import org.infinispan.query.dsl.*;


public class Application {
   public static void main(String args[]) throws Exception {

      // Cache<Object, Object> cache = new DefaultCacheManager("infinispan.xml").getCache("xml-configured-cache");
      // Cache<Object, Object> cache = new DefaultCacheManager(Application.class.getResourceAsStream("/infinispan.xml")).getCache("xml-configured-cache");

      EmbeddedCacheManager manager = new DefaultCacheManager();

      manager.defineConfiguration("custom-cache", new ConfigurationBuilder()
            .eviction().strategy(LIRS).maxEntries(100)
            .build());

      Cache<Object, Object> cache = manager.getCache("custom-cache");


      Area area1 = new Area("TIGRE", "TG", "Partido");

      System.out.println("");
      System.out.println("Add a entry");
      cache.put("Area1", area1);
      System.out.println("added 'Area1' as the key, and area1 object as the value for this entry");
      System.out.println("--------------------------------------");
      System.out.println("");

      
      Area area2 = new Area("SAN ISIDRO", "SI", "Partido");
      System.out.println("");
      System.out.println("Add a entry");
      cache.put("Area2", area2);
      System.out.println("added 'Area2' as the key, and area2 object as the value for this entry");
      System.out.println("--------------------------------------");
      System.out.println("");

      Area area3 = new Area("CORDOBA", "CB", "Provincia");
      System.out.println("");
      System.out.println("Add a entry");
      cache.put("Area3", area3);
      System.out.println("added 'Area3' as the key, and area3 object as the value for this entry");
      System.out.println("--------------------------------------");
      System.out.println("");


      System.out.println("Validate the entry is now in the cache");
      System.out.println("cache.size() is: " + cache.size() );
      System.out.println("--------------------------------------");
      System.out.println("");

      // // get the DSL query factory, to be used for constructing the Query object:
      // QueryFactory qf = Search.getQueryFactory(cache);
      // // create a query for all the areas that have a title which contains the word "engine":
      // Query query = qf.from(Area.class)
      //    .having("name").like("%CORDOBA%")
      //    .toBuilder().build();
      // // get the results
      // List<Area> list = query.list();

      // for(int i=0;i<list.size();i++){
      //    System.out.println(list.get(i));
      // } 

      // get the DSL query factory, to be used for constructing the Query object:
      // QueryFactory qf = Search.getQueryFactory(cache);
      // // create a query for all the areas that have a title which contains the word "engine":
      // Query query = qf.from(Area.class)
      //    .having("name").like("%CORDOBA%")
      //    .toBuilder().build();
      // // get the results
      // List<Area> list = query.list();

      // for(int i=0;i<list.size();i++){
      //    System.out.println(list.get(i));
      // } 


      // QueryFactory queryFactory = Search.getQueryFactory(cache);
      // // Defining a query to search for various authors and publication years
      // Query query = queryFactory.from(Area.class)
      //     .select("name")
      //     .having("alias").eq(Expression.param("aliasValue"))
      //     .and()
      //     .having("type").eq(Expression.param("typeValue"))
      //     .build();
      
      // // Set actual parameter values
      // query.setParameter("aliasValue", "CB");
      // query.setParameter("typeValue", "Provincia");
      
      // // Execute the query
      // List<Area> list = query.list();

      // for(int i=0;i<list.size();i++){
      //    System.out.println(list.get(i));
      // } 


      // get the query factory:
      // QueryFactory queryFactory = Search.getQueryFactory(cache);

      // Query q = queryFactory.from(Area.class)
      //             .having("name").eq("CORDOBA")
      //             .build();

      // List<Area> list = q.list();

      // for(int i=0;i<list.size();i++){
      //    System.out.println(list.get(i));
      // } 


      // Running Lucene queries - START
      // SearchManager searchManager = Search.getSearchManager(cache);
      
      // Query query = searchManager.buildQueryBuilderForClass(Area.class).get()
      //       .keyword().wildcard().onField("alias").matching("*CB*").createQuery();
      
      // CacheQuery<Area> cacheQuery = searchManager.getQuery(query);

      // try {
      //    System.out.println(cacheQuery.toString());
      // }
      //  catch(Exception e) {
      //    System.out.println("Lucene query didn't work");
      //  }
      
      // Running Lucene queries - END



      // System.out.println("Remove the entry from the cache");
      // Object v = cache.remove("key");
      // System.out.println("--------------------------------------");
      // System.out.println("");


      // System.out.println("Validate the entry is no longer in the cache");
      // assertEqual("value", v);
      // assertTrue(cache.isEmpty());
      // System.out.println("cache.isEmpty() results in : " + cache.isEmpty() );
      // System.out.println("--------------------------------------");
      // System.out.println("");



      // System.out.println("Add an entry with the key 'key'");
      // cache.put("key", "value");
      // System.out.println("And replace its value only if the key missing");
      // cache.putIfAbsent("key", "newValue");
      // System.out.println("Validate that the new value was not added");
      // assertEqual("value", cache.get("key"));
      // System.out.println("cache.get('key') = " + cache.get("key") );
      // System.out.println("--------------------------------------");
      // System.out.println("");


      // cache.clear();
      // assertTrue(cache.isEmpty());

      
      // System.out.println("cache.clear() was executed");
      // cache.clear();
      // assertTrue(cache.isEmpty());
      // System.out.println("cache.isEmpty() results in : " + cache.isEmpty() );
      // System.out.println("--------------------------------------");
      // System.out.println("");


      // //By default entries are immortal but we can override this on a per-key basis and provide lifespans.
      // cache.put("key", "value", 5, SECONDS);
      // assertTrue(cache.containsKey("key"));
      // Thread.sleep(10000);
      // assertFalse(cache.containsKey("key"));



      
   }

}


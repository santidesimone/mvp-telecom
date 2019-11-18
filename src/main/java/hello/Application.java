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

// import org.infinispan.query.Search;
// import org.infinispan.query.dsl.*;

import org.infinispan.configuration.cache.Index;
import org.infinispan.query.Search;
import org.infinispan.query.dsl.Query;
import org.infinispan.query.dsl.QueryFactory;


public class Application {
   public static void main(String args[]) throws Exception {

      // This way of creating the cache manager doesnt work
      // Cache<Object, Object> cache = new DefaultCacheManager("infinispan.xml").getCache("xml-configured-cache");
      // Cache<Object, Object> cache = new DefaultCacheManager(Application.class.getResourceAsStream("/infinispan.xml")).getCache("xml-configured-cache");

      // STARTS HERE
      // Creating the cache manage
      EmbeddedCacheManager manager = new DefaultCacheManager();

      manager.defineConfiguration("custom-cache", new ConfigurationBuilder()
            .eviction().strategy(LIRS).maxEntries(100)
            .build());

      Cache<Object, Object> cache = manager.getCache("custom-cache");

      // Adding some data to the cache
      Area area1 = new Area("TIGRE", "TG", "Partido");
      cache.put("Area1", area1);
      Area area2 = new Area("SAN ISIDRO", "SI", "Partido");
      cache.put("Area2", area2);
      Area area3 = new Area("CORDOBA", "CB", "Provincia");
      cache.put("Area3", area3);
      Area area4 = new Area("CORDOBA CAPITAL", "CB", "Localidad");
      cache.put("Area4", area4);
      Area area5 = new Area("SAN JUAN", "SJ", "Provincia");
      cache.put("Area5", area5);
      Area area6 = new Area("SAN MARTIN", "SM", "Partido");
      cache.put("Area6", area6);
      Area area7 = new Area("CAPITAN JUAN DE SAN MARTIN", "CJSM", "Localidad");
      cache.put("Area7", area7);
      Area area8 = new Area("CORRIENTES", "CR", "Provincia");
      cache.put("Area8", area8);
      Area area9 = new Area("BUENOS AIRES", "BSAS", "Provincia");
      cache.put("Area9", area9);
      Area area10 = new Area("JUJUY", "JJ", "Provincia");
      cache.put("Area10", area10);


      // Obtain a query factory for the cache
      QueryFactory queryFactory = Search.getQueryFactory(cache);


      // System.out.println("");
      // System.out.println("------------------");
      // System.out.println("GET ALL AREA OBJECTS");
      // // Construct a query
      // Class<?> type = conn.getType(cacheName);

      // Query allQuery = queryFactory
      //    .from(Area.class);
      // // Execute the query
      // List<Area> res = allQuery.list();
      // // List the results
      // res.forEach(area -> System.out.printf("Match: %s", area));
      // System.out.println("");


      System.out.println("");
      System.out.println("------------------");
      System.out.println("GET AREA OBJECTS HAVING PROPERTY NAME PROPERTY = CORDOBA");


      // Construct a query
      Query query = queryFactory.from(Area.class).having("name").eq("CORDOBA").toBuilder().build();
      // Execute the query
      List<Area> matches = query.list();
      // List the results
      matches.forEach(area -> System.out.printf("Match: %s", area));
      System.out.println("");

      // Stop the cache manager and release all resources
      // cacheManager.stop();

      System.out.println("");
      System.out.println("------------------");
      System.out.println("GET AREA OBJECTS MATCHING %COR% IN PROPERTY NAME");

      // get the DSL query factory, to be used for constructing the Query object:
      // QueryFactory qf = Search.getQueryFactory(cache);
      // // create a query for all the areas that have a title which contains the word "engine":
      Query newQuery = queryFactory.from(Area.class)
         .having("name").like("%COR%")
         .toBuilder().build();
      // // get the results
      List<Area> list = newQuery.list();
      // list.forEach(area -> System.out.printf("Match: %s", area));
      for(int i=0;i<list.size();i++){
         System.out.println(list.get(i));
      } 

      System.out.println("");
      System.out.println("------------------");
      System.out.println("GET AREA OBJECTS HAVING PROPERTY NAME LIKE %ISI%");

      Query yetAnewQuery = queryFactory.from(Area.class)
         .having("name")
         .like("%ISI%") // .like("%A") .like("CQ%")
         .toBuilder().build();
      // // get the results
      List<Area> result = yetAnewQuery.list();
      result.forEach(area -> System.out.printf("Match: %s", area));


      System.out.println("");
      System.out.println("------------------");
      System.out.println("");


   }

}



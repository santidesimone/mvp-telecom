package org.telecom.infinispan.cache.solution;

 
// import org.hibernate.search.annotations.Analyze;
// import org.hibernate.search.annotations.Field;
// import org.hibernate.search.annotations.Indexed;
// import org.hibernate.search.annotations.Store;
 
// @Indexed
public class Area {
//    @Field(store = Store.YES, analyze = Analyze.NO)
   String name;
 
//    @Field(store = Store.YES, analyze = Analyze.NO, indexNullAs = Field.DEFAULT_NULL_TOKEN)
    String alias;
    
//    @Field(store = Store.YES, analyze = Analyze.NO, indexNullAs = Field.DEFAULT_NULL_TOKEN)
    String type;
 
   public Area(String name, String alias, String type) {
      this.name = name;
      this.alias = alias;
      this.type = type;
   }
 
   @Override
   public String toString() {
      return "Area [ name=" + name + ", alias=" + alias + " + type=" + type + " ]";
   }
}
/*    */ package com.bioxx.tfc.Core.Util;
/*    */ 
/*    */ import com.google.common.base.Strings;
/*    */ import com.google.common.collect.ImmutableMap;
/*    */ import java.util.HashMap;
/*    */ import java.util.Locale;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CaseInsensitiveHashMap<V>
/*    */   extends HashMap<String, V>
/*    */ {
/*    */   public CaseInsensitiveHashMap(int initialCapacity, float loadFactor) {
/* 21 */     super(initialCapacity, loadFactor);
/*    */   }
/*    */ 
/*    */   
/*    */   public CaseInsensitiveHashMap(int initialCapacity) {
/* 26 */     super(initialCapacity);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public CaseInsensitiveHashMap() {}
/*    */ 
/*    */ 
/*    */   
/*    */   public CaseInsensitiveHashMap(Map<? extends String, ? extends V> m) {
/* 36 */     super((Map)toLowercase(m));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private static Map<String, Object> toLowercase(Map<? extends String, ?> m) {
/* 42 */     ImmutableMap.Builder<String, Object> temp = ImmutableMap.builder();
/*    */ 
/*    */ 
/*    */     
/* 46 */     for (Map.Entry<? extends String, ?> entry : m.entrySet())
/*    */     {
/* 48 */       temp.put(toLowercase(entry.getKey()), entry.getValue());
/*    */     }
/* 50 */     return (Map<String, Object>)temp.build();
/*    */   }
/*    */ 
/*    */   
/*    */   private static String toString(Object o) {
/* 55 */     if (o == null) return null; 
/* 56 */     return o.toString();
/*    */   }
/*    */ 
/*    */   
/*    */   private static String toLowercase(String key) {
/* 61 */     if (Strings.isNullOrEmpty(key)) return key; 
/* 62 */     return key.toLowerCase(Locale.ENGLISH);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public V get(Object key) {
/* 69 */     return get(toString(key));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public V put(String key, V value) {
/* 75 */     return super.put(toLowercase(key), value);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void putAll(Map<? extends String, ? extends V> m) {
/* 81 */     super.putAll((Map)toLowercase(m));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public V remove(Object key) {
/* 87 */     return remove(toString(key));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public V get(String key) {
/* 93 */     return super.get(toLowercase(key));
/*    */   }
/*    */ 
/*    */   
/*    */   public V remove(String key) {
/* 98 */     return super.remove(toLowercase(key));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Core\Util\CaseInsensitiveHashMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
/*    */ package com.bioxx.tfc.Core.Metal;
/*    */ 
/*    */ import com.bioxx.tfc.api.Metal;
/*    */ import java.util.HashMap;
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import net.minecraft.item.Item;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MetalRegistry
/*    */ {
/* 13 */   public static MetalRegistry instance = new MetalRegistry();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 19 */   private Map<String, Metal> hash = new HashMap<String, Metal>();
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean addMetal(Metal m, Alloy.EnumTier soloTier) {
/* 25 */     if (this.hash.containsKey(m.name)) {
/* 26 */       return false;
/*    */     }
/* 28 */     this.hash.put(m.name, m);
/*    */     
/* 30 */     Alloy alloy = new Alloy(m, soloTier);
/* 31 */     alloy.addIngred(m, 99.0F, 100.0F);
/* 32 */     AlloyManager.INSTANCE.addAlloy(alloy);
/*    */     
/* 34 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public Metal getMetalFromItem(Item i) {
/* 39 */     Iterator<Metal> iter = this.hash.values().iterator();
/* 40 */     while (iter.hasNext()) {
/*    */       
/* 42 */       Metal m = iter.next();
/* 43 */       if (m.ingot == i || m.meltedItem == i) {
/* 44 */         return m;
/*    */       }
/*    */     } 
/* 47 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public Metal getMetalFromString(String s) {
/* 52 */     if (this.hash.containsKey(s))
/* 53 */       return this.hash.get(s); 
/* 54 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Core\Metal\MetalRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
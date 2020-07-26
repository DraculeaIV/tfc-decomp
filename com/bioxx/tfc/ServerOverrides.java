/*    */ package com.bioxx.tfc;
/*    */ 
/*    */ import com.bioxx.tfc.Core.TFC_Core;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.SharedMonsterAttributes;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ServerOverrides
/*    */ {
/*    */   public static boolean canPlayerMove(EntityLivingBase entity) {
/* 13 */     double ref = entity.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111126_e();
/* 14 */     if (ref > 0.001D) {
/* 15 */       return true;
/*    */     }
/*    */     
/* 18 */     entity.field_70181_x = -0.15D;
/* 19 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static int isValidSurface(Block b) {
/* 25 */     if (TFC_Core.isFence(b) || (b != null && b.func_149645_b() == 11))
/* 26 */       return 11; 
/* 27 */     return b.func_149645_b();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\ServerOverrides.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
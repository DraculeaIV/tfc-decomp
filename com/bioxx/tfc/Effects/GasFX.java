/*    */ package com.bioxx.tfc.Effects;
/*    */ 
/*    */ import com.bioxx.tfc.Core.TFC_Textures;
/*    */ import net.minecraft.client.particle.EntityFX;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GasFX
/*    */   extends EntityFX
/*    */ {
/*    */   public GasFX(World world, double par2, double par4, double par6, double par8, double par10, double par12) {
/* 14 */     super(world, par2, par4, par6, par8, par10, par12);
/* 15 */     func_110125_a(TFC_Textures.gasFXIcon);
/* 16 */     func_70105_a(1.0F, 1.0F);
/* 17 */     this.field_70547_e = (int)(12.0F / (this.field_70146_Z.nextFloat() * 0.9F + 0.1F));
/* 18 */     this.field_82339_as = 0.05F;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int func_70537_b() {
/* 24 */     return 1;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Effects\GasFX.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
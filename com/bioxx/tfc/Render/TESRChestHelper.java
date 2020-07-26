/*    */ package com.bioxx.tfc.Render;
/*    */ 
/*    */ import com.bioxx.tfc.TileEntities.TEChest;
/*    */ import com.bioxx.tfc.api.Constant.Global;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ 
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class TESRChestHelper
/*    */ {
/* 15 */   public static TESRChestHelper instance = new TESRChestHelper();
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 20 */   private TEChest[] chestTypes = new TEChest[Global.WOOD_ALL.length * 2]; public TESRChestHelper() {
/* 21 */     for (int i = 0; i < Global.WOOD_ALL.length; i++) {
/*    */       
/* 23 */       this.chestTypes[i] = new TEChest(i, false);
/* 24 */       this.chestTypes[Global.WOOD_ALL.length + i] = new TEChest(i, true);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void renderChest(Block block, int meta, float modelID) {
/* 32 */     TileEntityRendererDispatcher.field_147556_a.func_147549_a((TileEntity)this.chestTypes[meta], 0.0D, 0.0D, 0.0D, 0.0F);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\TESRChestHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
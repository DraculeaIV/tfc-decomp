/*    */ package com.bioxx.tfc.api.Tools;
/*    */ 
/*    */ import com.bioxx.tfc.Core.Player.PlayerInfo;
/*    */ import com.bioxx.tfc.Core.Player.PlayerManagerTFC;
/*    */ import com.bioxx.tfc.api.TFCBlocks;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ChiselMode
/*    */ {
/*    */   private ResourceLocation resourcelocation;
/*    */   private int textureU;
/*    */   private int textureV;
/*    */   private int divX;
/*    */   private int divY;
/*    */   private int divZ;
/*    */   
/*    */   public ResourceLocation getResourceLocation() {
/* 30 */     return this.resourcelocation;
/*    */   }
/*    */   
/*    */   public int getTextureU() {
/* 34 */     return this.textureU;
/*    */   }
/*    */   
/*    */   public int getTextureV() {
/* 38 */     return this.textureV;
/*    */   }
/*    */   
/*    */   public int getDivX(Block block) {
/* 42 */     return this.divX;
/*    */   }
/*    */   
/*    */   public int getDivY(Block block) {
/* 46 */     return this.divY;
/*    */   }
/*    */   public void setDivision(int hitSide) {}
/*    */   public int getDivZ(Block block) {
/* 50 */     return this.divZ;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean onUsedHandler(World world, EntityPlayer player, int x, int y, int z, Block id, int meta, int side, float hitX, float hitY, float hitZ) {
/* 55 */     return false;
/*    */   }
/*    */   public boolean isChiselable(Block block) {
/* 58 */     boolean isChiselable = (block == TFCBlocks.planks || block instanceof com.bioxx.tfc.Blocks.Terrain.BlockCobble || block instanceof com.bioxx.tfc.Blocks.Terrain.BlockStone || block instanceof com.bioxx.tfc.Blocks.Terrain.BlockSmooth);
/*    */ 
/*    */ 
/*    */     
/* 62 */     return isChiselable;
/*    */   }
/*    */   
/*    */   public int hasChisel(EntityPlayer player) {
/* 66 */     int hasChisel = -1;
/* 67 */     if (player.field_71071_by.field_70462_a[player.field_71071_by.field_70461_c] != null && player.field_71071_by.field_70462_a[player.field_71071_by.field_70461_c].func_77973_b() instanceof com.bioxx.tfc.Items.Tools.ItemChisel) {
/* 68 */       hasChisel = player.field_71071_by.field_70461_c;
/*    */     }
/* 70 */     return hasChisel;
/*    */   }
/*    */   
/*    */   public static PlayerInfo playerInfo(World world, EntityPlayer player) {
/*    */     PlayerInfo pi;
/* 75 */     if (!world.field_72995_K) {
/*    */       
/* 77 */       pi = PlayerManagerTFC.getInstance().getPlayerInfoFromPlayer(player);
/*    */     }
/*    */     else {
/*    */       
/* 81 */       pi = PlayerManagerTFC.getInstance().getClientPlayer();
/*    */     } 
/* 83 */     return pi;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\api\Tools\ChiselMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
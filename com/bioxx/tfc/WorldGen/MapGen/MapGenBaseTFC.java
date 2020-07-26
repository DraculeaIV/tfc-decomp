/*    */ package com.bioxx.tfc.WorldGen.MapGen;
/*    */ 
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraft.world.chunk.IChunkProvider;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MapGenBaseTFC
/*    */ {
/* 12 */   protected int range = 8;
/*    */ 
/*    */   
/* 15 */   protected Random rand = new Random();
/*    */ 
/*    */   
/*    */   protected World worldObj;
/*    */ 
/*    */   
/*    */   public void generate(IChunkProvider par1IChunkProvider, World par2World, int par3, int par4, Block[] idsBig) {
/* 22 */     int var6 = this.range;
/* 23 */     this.worldObj = par2World;
/* 24 */     this.rand.setSeed(par2World.func_72905_C());
/* 25 */     long var7 = this.rand.nextLong();
/* 26 */     long var9 = this.rand.nextLong();
/*    */     
/* 28 */     for (int var11 = par3 - var6; var11 <= par3 + var6; var11++) {
/*    */       
/* 30 */       long var13 = var11 * var7;
/* 31 */       for (int var12 = par4 - var6; var12 <= par4 + var6; var12++) {
/*    */         
/* 33 */         long var15 = var12 * var9;
/* 34 */         this.rand.setSeed(var13 ^ var15 ^ par2World.func_72905_C());
/* 35 */         recursiveGenerate(par2World, var11, var12, par3, par4, idsBig);
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   protected void recursiveGenerate(World par1World, int par2, int par3, int par4, int par5, Block[] idsBig) {}
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\WorldGen\MapGen\MapGenBaseTFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
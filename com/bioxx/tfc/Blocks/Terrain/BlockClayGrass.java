/*    */ package com.bioxx.tfc.Blocks.Terrain;
/*    */ 
/*    */ import com.bioxx.tfc.Core.TFC_Core;
/*    */ import com.bioxx.tfc.api.TFCBlocks;
/*    */ import com.bioxx.tfc.api.TFCItems;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.world.IBlockAccess;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraftforge.common.util.ForgeDirection;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BlockClayGrass
/*    */   extends BlockGrass
/*    */ {
/*    */   public BlockClayGrass(int texOff) {
/* 21 */     super(texOff);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int func_149645_b() {
/* 27 */     return TFCBlocks.clayGrassRenderId;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int func_149692_a(int dmg) {
/* 33 */     return dmg;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Item func_149650_a(int metadata, Random rand, int fortune) {
/* 39 */     return TFCItems.clayBall;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int func_149745_a(Random rand) {
/* 45 */     return 1 + rand.nextInt(3);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
/* 55 */     ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
/* 56 */     int count = func_149745_a(world.field_73012_v);
/* 57 */     Item item = func_149650_a(metadata, world.field_73012_v, fortune);
/* 58 */     for (int i = 0; i < count; i++)
/* 59 */       ret.add(new ItemStack(item, 1, 0)); 
/* 60 */     return ret;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_149695_a(World world, int x, int y, int z, Block b) {}
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_149674_a(World world, int x, int y, int z, Random rand) {
/* 72 */     if (world.func_147439_a(x, y + 1, z).isSideSolid((IBlockAccess)world, x, y + 1, z, ForgeDirection.DOWN)) {
/*    */       
/* 74 */       world.func_147465_d(x, y, z, TFC_Core.getTypeForClay(world.func_72805_g(x, y, z) + this.textureOffset), world.func_72805_g(x, y, z), 2);
/*    */     }
/* 76 */     else if (world.func_72937_j(x, y + 1, z)) {
/*    */       
/* 78 */       spreadGrass(world, x, y, z, rand);
/*    */     } 
/* 80 */     world.func_147471_g(x, y, z);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\Terrain\BlockClayGrass.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
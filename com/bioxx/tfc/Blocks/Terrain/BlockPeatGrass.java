/*    */ package com.bioxx.tfc.Blocks.Terrain;
/*    */ 
/*    */ import com.bioxx.tfc.api.TFCBlocks;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.List;
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.world.IBlockAccess;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraftforge.common.util.ForgeDirection;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BlockPeatGrass
/*    */   extends BlockGrass
/*    */ {
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_149666_a(Item item, CreativeTabs tabs, List<ItemStack> list) {
/* 33 */     list.add(new ItemStack((Block)this, 1, 0));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Item func_149650_a(int metadata, Random rand, int fortune) {
/* 42 */     return Item.func_150898_a(TFCBlocks.peat);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int func_149645_b() {
/* 48 */     return TFCBlocks.peatGrassRenderId;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int func_149745_a(Random rand) {
/* 57 */     return 1;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_149695_a(World world, int x, int y, int z, Block b) {
/* 63 */     if (!world.func_72899_e(x, y - 1, z)) {
/*    */       
/* 65 */       int meta = world.func_72805_g(x, y, z);
/* 66 */       world.func_147465_d(x, y, z, TFCBlocks.peat, meta, 2);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_149674_a(World world, int x, int y, int z, Random rand) {
/* 73 */     if (world.func_147439_a(x, y + 1, z).isSideSolid((IBlockAccess)world, x, y + 1, z, ForgeDirection.DOWN)) {
/* 74 */       world.func_147449_b(x, y, z, TFCBlocks.peat);
/* 75 */     } else if (world.func_72937_j(x, y + 1, z)) {
/*    */       
/* 77 */       spreadGrass(world, x, y, z, rand);
/*    */     } 
/*    */     
/* 80 */     world.func_147471_g(x, y, z);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\Terrain\BlockPeatGrass.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
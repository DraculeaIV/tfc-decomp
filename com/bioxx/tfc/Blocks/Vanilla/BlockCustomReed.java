/*    */ package com.bioxx.tfc.Blocks.Vanilla;
/*    */ 
/*    */ import com.bioxx.tfc.Core.TFC_Core;
/*    */ import com.bioxx.tfc.api.TFCItems;
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.BlockReed;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraftforge.common.IPlantable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BlockCustomReed
/*    */   extends BlockReed
/*    */   implements IPlantable
/*    */ {
/*    */   public BlockCustomReed() {
/* 21 */     float var3 = 0.375F;
/* 22 */     func_149676_a(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, 1.0F, 0.5F + var3);
/* 23 */     func_149675_a(true);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_149742_c(World par1World, int par2, int par3, int par4) {
/* 29 */     Block var5 = par1World.func_147439_a(par2, par3 - 1, par4);
/* 30 */     boolean correctSoil = (TFC_Core.isSoil(var5) || TFC_Core.isSand(var5) || TFC_Core.isFarmland(var5));
/* 31 */     return (var5 == this) ? true : (!correctSoil ? false : ((par1World.func_147439_a(par2 - 1, par3 - 1, par4).func_149688_o() == Material.field_151586_h) ? true : ((par1World.func_147439_a(par2 + 1, par3 - 1, par4).func_149688_o() == Material.field_151586_h) ? true : ((par1World.func_147439_a(par2, par3 - 1, par4 - 1).func_149688_o() == Material.field_151586_h) ? true : ((par1World.func_147439_a(par2, par3 - 1, par4 + 1).func_149688_o() == Material.field_151586_h))))));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Item func_149650_a(int par1, Random par2, int par3) {
/* 37 */     return TFCItems.reeds;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Item func_149694_d(World world, int x, int y, int z) {
/* 43 */     return TFCItems.reeds;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\Vanilla\BlockCustomReed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
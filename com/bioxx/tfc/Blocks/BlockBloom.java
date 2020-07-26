/*    */ package com.bioxx.tfc.Blocks;
/*    */ 
/*    */ import com.bioxx.tfc.TileEntities.TEBloom;
/*    */ import com.bioxx.tfc.api.TFCBlocks;
/*    */ import com.bioxx.tfc.api.TFCItems;
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.item.EntityItem;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BlockBloom
/*    */   extends BlockTerraContainer
/*    */ {
/*    */   public BlockBloom() {
/* 22 */     super(Material.field_151573_f);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_149662_c() {
/* 28 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int func_149692_a(int j) {
/* 34 */     return j;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_149651_a(IIconRegister iconRegisterer) {
/* 40 */     this.field_149761_L = iconRegisterer.func_94245_a("terrafirmacraft:devices/Iron Bloom");
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public TileEntity func_149915_a(World w, int meta) {
/* 46 */     return (TileEntity)new TEBloom();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Item func_149650_a(int i, Random rand, int j) {
/* 52 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_149725_f(World world, int i, int j, int k, int meta) {
/* 58 */     TEBloom te = (TEBloom)world.func_147438_o(i, j, k);
/* 59 */     EntityItem ei = new EntityItem(world, i, j, k, new ItemStack(TFCItems.rawBloom, 1, te.size));
/*    */     
/* 61 */     int[] pos = getBloomery(world, i, j, k);
/* 62 */     ei.field_70159_w = 0.0D; ei.field_70181_x = 0.0D; ei.field_70179_y = 0.0D;
/* 63 */     ei.func_70107_b(i + 0.5D + pos[0], j + 0.5D, k + 0.5D + pos[1]);
/* 64 */     ei.field_145804_b = 0;
/* 65 */     world.func_72838_d((Entity)ei);
/*    */   }
/*    */ 
/*    */   
/*    */   public int[] getBloomery(World world, int x, int y, int z) {
/* 70 */     if (world.func_147439_a(x + 1, y, z) == TFCBlocks.bloomery)
/* 71 */       return new int[] { 2, 0 }; 
/* 72 */     if (world.func_147439_a(x - 1, y, z) == TFCBlocks.bloomery)
/* 73 */       return new int[] { -2, 0 }; 
/* 74 */     if (world.func_147439_a(x, y, z + 1) == TFCBlocks.bloomery)
/* 75 */       return new int[] { 0, 2 }; 
/* 76 */     if (world.func_147439_a(x, y, z - 1) == TFCBlocks.bloomery) {
/* 77 */       return new int[] { 0, -2 };
/*    */     }
/* 79 */     return new int[] { 0, 0 };
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\BlockBloom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
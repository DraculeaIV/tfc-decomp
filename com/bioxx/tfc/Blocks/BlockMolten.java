/*    */ package com.bioxx.tfc.Blocks;
/*    */ 
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.IIcon;
/*    */ import net.minecraft.util.MovingObjectPosition;
/*    */ import net.minecraft.world.IBlockAccess;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ public class BlockMolten
/*    */   extends BlockTerra
/*    */ {
/*    */   private IIcon moltenOff;
/*    */   
/*    */   public BlockMolten() {
/* 21 */     super(Material.field_151573_f);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int getLightValue(IBlockAccess world, int x, int y, int z) {
/* 27 */     int meta = world.func_72805_g(x, y, z);
/* 28 */     if ((meta & 0x8) > 0)
/* 29 */       return 15; 
/* 30 */     return 0;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_149719_a(IBlockAccess access, int i, int j, int k) {
/* 36 */     int meta = access.func_72805_g(i, j, k) & 0x7;
/* 37 */     float f = 0.125F;
/* 38 */     func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, f + f * meta, 1.0F);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public IIcon func_149691_a(int side, int meta) {
/* 44 */     if ((meta & 0x8) == 0)
/* 45 */       return this.moltenOff; 
/* 46 */     return this.field_149761_L;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_149651_a(IIconRegister iconRegisterer) {
/* 52 */     this.field_149761_L = iconRegisterer.func_94245_a("terrafirmacraft:devices/Molten Rock");
/* 53 */     this.moltenOff = iconRegisterer.func_94245_a("terrafirmacraft:devices/Molten Rock Off");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_149636_a(World world, EntityPlayer entityplayer, int i, int j, int k, int l) {}
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_149662_c() {
/* 65 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_149686_d() {
/* 71 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
/* 77 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Item func_149650_a(int metadata, Random rand, int fortune) {
/* 83 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\BlockMolten.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
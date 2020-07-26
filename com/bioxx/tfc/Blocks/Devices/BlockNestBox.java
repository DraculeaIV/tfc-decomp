/*    */ package com.bioxx.tfc.Blocks.Devices;
/*    */ 
/*    */ import com.bioxx.tfc.Blocks.BlockTerraContainer;
/*    */ import com.bioxx.tfc.Core.TFCTabs;
/*    */ import com.bioxx.tfc.Core.TFC_Textures;
/*    */ import com.bioxx.tfc.TerraFirmaCraft;
/*    */ import com.bioxx.tfc.TileEntities.TENestBox;
/*    */ import com.bioxx.tfc.api.TFCBlocks;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ import net.minecraft.util.IIcon;
/*    */ import net.minecraft.world.IBlockAccess;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BlockNestBox
/*    */   extends BlockTerraContainer
/*    */ {
/*    */   public BlockNestBox() {
/* 25 */     super(Material.field_151575_d);
/* 26 */     func_149647_a(TFCTabs.TFC_DECORATION);
/* 27 */     func_149676_a(0.1F, 0.0F, 0.1F, 0.9F, 0.4F, 0.9F);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_149662_c() {
/* 33 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_149686_d() {
/* 39 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int func_149645_b() {
/* 45 */     return TFCBlocks.nestBoxRenderId;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_149651_a(IIconRegister iconRegisterer) {
/* 51 */     this.field_149761_L = TFC_Textures.invisibleTexture;
/*    */   }
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public boolean func_149646_a(IBlockAccess par1iBlockAccess, int par2, int par3, int par4, int par5) {
/* 57 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_149655_b(IBlockAccess par1IBlockAccess, int i, int j, int k) {
/* 63 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public IIcon func_149691_a(int side, int meta) {
/* 69 */     return this.field_149761_L;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_149727_a(World world, int x, int y, int z, EntityPlayer entityplayer, int side, float hitX, float hitY, float hitZ) {
/* 75 */     if (!world.field_72995_K) {
/*    */ 
/*    */       
/* 78 */       entityplayer.openGui(TerraFirmaCraft.instance, 41, world, x, y, z);
/* 79 */       return true;
/*    */     } 
/* 81 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public TileEntity func_149915_a(World var1, int var2) {
/* 87 */     return (TileEntity)new TENestBox();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\Devices\BlockNestBox.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
/*     */ package com.bioxx.tfc.Blocks.Devices;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFCTabs;
/*     */ import com.bioxx.tfc.Core.TFC_Textures;
/*     */ import com.bioxx.tfc.TileEntities.TEStand;
/*     */ import com.bioxx.tfc.api.Constant.Global;
/*     */ import com.bioxx.tfc.api.Interfaces.IEquipable;
/*     */ import com.bioxx.tfc.api.Interfaces.IMultipleBlock;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.Explosion;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockStand2
/*     */   extends BlockStand
/*     */   implements IMultipleBlock, IEquipable
/*     */ {
/*     */   private String[] woodNames;
/*     */   
/*     */   public BlockStand2() {
/*  34 */     func_149647_a(TFCTabs.TFC_DECORATION);
/*  35 */     func_149676_a(0.125F, 0.0F, 0.125F, 0.875F, 1.0F, 0.875F);
/*  36 */     this.woodNames = new String[Global.WOOD_ALL.length - 16];
/*  37 */     System.arraycopy(Global.WOOD_ALL, 16, this.woodNames, 0, Global.WOOD_ALL.length - 16);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149651_a(IIconRegister iconRegisterer) {
/*  43 */     this.field_149761_L = iconRegisterer.func_94245_a("terrafirmacraft:wood/BarrelHoop");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IIcon func_149691_a(int side, int meta) {
/*  49 */     if (side == 0 || side == 1) {
/*  50 */       return TFC_Textures.invisibleTexture;
/*     */     }
/*  52 */     return this.field_149761_L;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149666_a(Item item, CreativeTabs tabs, List<ItemStack> list) {
/*  59 */     for (int i = 0; i < this.woodNames.length; i++) {
/*  60 */       list.add(new ItemStack((Block)this, 1, i));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149692_a(int dmg) {
/*  66 */     return dmg;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/*  72 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149689_a(World world, int i, int j, int k, EntityLivingBase entityliving, ItemStack is) {
/*  78 */     super.func_149689_a(world, i, j, k, entityliving, is);
/*  79 */     TileEntity te = world.func_147438_o(i, j, k);
/*  80 */     if (te instanceof TEStand) {
/*     */       
/*  82 */       TEStand tes = (TEStand)te;
/*  83 */       tes.yaw = ((int)(entityliving.field_70177_z % 360.0F + 360.0F + 45.0F) / 90 * 90 % 360);
/*  84 */       if (tes.yaw % 180.0F == 0.0F)
/*  85 */         tes.yaw += 180.0F; 
/*  86 */       world.func_147449_b(i, j + 1, k, (Block)this);
/*  87 */       world.func_72921_c(i, j + 1, k, is.func_77960_j(), 0);
/*  88 */       world.func_147455_a(i, j + 1, k, (TileEntity)new TEStand());
/*  89 */       ((TEStand)world.func_147438_o(i, j + 1, k)).isTop = true;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/*  96 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/* 102 */     return TFCBlocks.standRenderId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149726_b(World par1World, int par2, int par3, int par4) {
/* 111 */     super.func_149726_b(par1World, par2, par3, par4);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149723_a(World par1World, int par2, int par3, int par4, Explosion par5Explosion) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Block getBlockTypeForRender() {
/* 123 */     return TFCBlocks.planks2;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\Devices\BlockStand2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
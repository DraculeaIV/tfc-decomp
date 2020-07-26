/*    */ package com.bioxx.tfc.Blocks;
/*    */ 
/*    */ import com.bioxx.tfc.Core.TFCTabs;
/*    */ import com.bioxx.tfc.api.Constant.Global;
/*    */ import com.bioxx.tfc.api.Tools.IToolChisel;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.List;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.IIcon;
/*    */ import net.minecraft.world.IBlockAccess;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BlockMetal
/*    */   extends BlockTerra
/*    */ {
/*    */   protected String[] metalNames;
/*    */   protected IIcon[] icons;
/*    */   
/*    */   public BlockMetal(Material material) {
/* 32 */     super(Material.field_151573_f);
/* 33 */     func_149647_a(TFCTabs.TFC_MATERIALS);
/* 34 */     this.metalNames = new String[16];
/* 35 */     System.arraycopy(Global.METAL_ALL, 0, this.metalNames, 0, 16);
/* 36 */     this.icons = new IIcon[this.metalNames.length];
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_149666_a(Item par1, CreativeTabs par2CreativeTabs, List<ItemStack> list) {
/* 46 */     for (int i = 0; i < this.metalNames.length; i++) {
/* 47 */       list.add(new ItemStack(this, 1, i));
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_149692_a(int meta) {
/* 53 */     return meta;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public IIcon func_149691_a(int side, int meta) {
/* 60 */     return this.icons[meta];
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_149651_a(IIconRegister registerer) {
/* 66 */     for (int i = 0; i < this.metalNames.length; i++) {
/* 67 */       this.icons[i] = registerer.func_94245_a("terrafirmacraft:metal/" + this.metalNames[i]);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_149727_a(World world, int x, int y, int z, EntityPlayer entityplayer, int side, float par7, float par8, float par9) {
/* 76 */     boolean hasHammer = false;
/* 77 */     for (int i = 0; i < 9; i++) {
/* 78 */       if (entityplayer.field_71071_by.field_70462_a[i] != null && entityplayer.field_71071_by.field_70462_a[i].func_77973_b() instanceof com.bioxx.tfc.Items.Tools.ItemHammer)
/* 79 */         hasHammer = true; 
/* 80 */     }  if (!world.field_72995_K && entityplayer.func_71045_bC() != null && entityplayer
/* 81 */       .func_71045_bC().func_77973_b() instanceof IToolChisel && hasHammer && ((IToolChisel)entityplayer
/* 82 */       .func_71045_bC().func_77973_b()).canChisel(entityplayer, x, y, z)) {
/*    */       
/* 84 */       Block block = world.func_147439_a(x, y, z);
/* 85 */       byte meta = (byte)world.func_72805_g(x, y, z);
/*    */       
/* 87 */       return ((IToolChisel)entityplayer.func_71045_bC().func_77973_b()).onUsed(world, entityplayer, x, y, z, block, meta, side, par7, par8, par9);
/*    */     } 
/* 89 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isBeaconBase(IBlockAccess worldObj, int x, int y, int z, int beaconX, int beaconY, int beaconZ) {
/* 96 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\BlockMetal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
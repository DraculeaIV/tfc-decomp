/*    */ package com.bioxx.tfc.Blocks;
/*    */ 
/*    */ import com.bioxx.tfc.Core.TFCTabs;
/*    */ import com.bioxx.tfc.api.Constant.Global;
/*    */ import com.bioxx.tfc.api.TFCBlocks;
/*    */ import com.bioxx.tfc.api.Tools.IToolChisel;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.List;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.IIcon;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BlockPlanks
/*    */   extends BlockTerra
/*    */ {
/*    */   protected String[] woodNames;
/*    */   protected IIcon[] icons;
/*    */   
/*    */   public BlockPlanks(Material material) {
/* 33 */     super(Material.field_151575_d);
/* 34 */     func_149647_a(TFCTabs.TFC_BUILDING);
/* 35 */     this.woodNames = new String[16];
/* 36 */     System.arraycopy(Global.WOOD_ALL, 0, this.woodNames, 0, 16);
/* 37 */     this.icons = new IIcon[this.woodNames.length];
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_149666_a(Item par1, CreativeTabs par2CreativeTabs, List<ItemStack> list) {
/* 47 */     for (int i = 0; i < this.woodNames.length; i++) {
/* 48 */       list.add(new ItemStack(this, 1, i));
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_149692_a(int j) {
/* 54 */     return j;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public IIcon func_149691_a(int i, int j) {
/* 60 */     if (j < 0)
/* 61 */       return this.icons[0]; 
/* 62 */     if (j < this.icons.length)
/* 63 */       return this.icons[j]; 
/* 64 */     return TFCBlocks.planks2.func_149691_a(i, j - 16);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_149651_a(IIconRegister registerer) {
/* 70 */     for (int i = 0; i < this.woodNames.length; i++)
/* 71 */       this.icons[i] = registerer.func_94245_a("terrafirmacraft:wood/" + this.woodNames[i] + " Plank"); 
/* 72 */     Blocks.field_150344_f.func_149651_a(registerer);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_149727_a(World world, int x, int y, int z, EntityPlayer entityplayer, int side, float par7, float par8, float par9) {
/* 81 */     boolean hasHammer = false;
/* 82 */     for (int i = 0; i < 9; i++) {
/* 83 */       if (entityplayer.field_71071_by.field_70462_a[i] != null && entityplayer.field_71071_by.field_70462_a[i].func_77973_b() instanceof com.bioxx.tfc.Items.Tools.ItemHammer)
/* 84 */         hasHammer = true; 
/* 85 */     }  if (!world.field_72995_K && entityplayer.func_71045_bC() != null && entityplayer
/* 86 */       .func_71045_bC().func_77973_b() instanceof IToolChisel && hasHammer && ((IToolChisel)entityplayer
/* 87 */       .func_71045_bC().func_77973_b()).canChisel(entityplayer, x, y, z)) {
/*    */       
/* 89 */       Block block = world.func_147439_a(x, y, z);
/* 90 */       byte meta = (byte)world.func_72805_g(x, y, z);
/*    */       
/* 92 */       return ((IToolChisel)entityplayer.func_71045_bC().func_77973_b()).onUsed(world, entityplayer, x, y, z, block, meta, side, par7, par8, par9);
/*    */     } 
/* 94 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\BlockPlanks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
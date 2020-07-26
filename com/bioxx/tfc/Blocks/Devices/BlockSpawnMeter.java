/*    */ package com.bioxx.tfc.Blocks.Devices;
/*    */ 
/*    */ import com.bioxx.tfc.Blocks.BlockTerraContainer;
/*    */ import com.bioxx.tfc.Core.TFCTabs;
/*    */ import com.bioxx.tfc.TileEntities.TESpawnMeter;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ import net.minecraft.util.IIcon;
/*    */ import net.minecraft.world.IBlockAccess;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ public class BlockSpawnMeter
/*    */   extends BlockTerraContainer
/*    */ {
/*    */   private IIcon iconTop;
/* 18 */   private IIcon[] icons = new IIcon[9];
/*    */ 
/*    */   
/*    */   public BlockSpawnMeter() {
/* 22 */     super(Material.field_151576_e);
/* 23 */     func_149647_a(TFCTabs.TFC_DEVICES);
/* 24 */     func_149715_a(1.0F);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int getLightValue(IBlockAccess world, int x, int y, int z) {
/* 30 */     int meta = world.func_72805_g(x, y, z);
/* 31 */     return Math.min(meta, 8);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_149662_c() {
/* 37 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int func_149692_a(int j) {
/* 43 */     return j;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public IIcon func_149691_a(int i, int j) {
/* 49 */     if (i < 2)
/* 50 */       return this.iconTop; 
/* 51 */     return this.icons[j];
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_149651_a(IIconRegister iconRegisterer) {
/* 57 */     this.iconTop = iconRegisterer.func_94245_a("terrafirmacraft:devices/MeterTop");
/* 58 */     for (int i = 0; i < 9; i++) {
/* 59 */       this.icons[i] = iconRegisterer.func_94245_a("terrafirmacraft:devices/Meter" + i);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public TileEntity func_149915_a(World var1, int var2) {
/* 65 */     return (TileEntity)new TESpawnMeter();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\Devices\BlockSpawnMeter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
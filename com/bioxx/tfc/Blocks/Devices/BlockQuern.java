/*     */ package com.bioxx.tfc.Blocks.Devices;
/*     */ 
/*     */ import com.bioxx.tfc.Blocks.BlockTerraContainer;
/*     */ import com.bioxx.tfc.Core.TFCTabs;
/*     */ import com.bioxx.tfc.Core.TFC_Achievements;
/*     */ import com.bioxx.tfc.TerraFirmaCraft;
/*     */ import com.bioxx.tfc.TileEntities.TEQuern;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.stats.StatBase;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockQuern
/*     */   extends BlockTerraContainer
/*     */ {
/*     */   private IIcon quernBase;
/*     */   private IIcon quernTop1;
/*     */   private IIcon quernTop2;
/*     */   
/*     */   public BlockQuern() {
/*  32 */     super(Material.field_151576_e);
/*  33 */     func_149647_a(TFCTabs.TFC_DEVICES);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149727_a(World world, int x, int y, int z, EntityPlayer entityplayer, int side, float hitX, float hitY, float hitZ) {
/*  39 */     super.func_149727_a(world, x, y, z, entityplayer, side, hitX, hitY, hitZ);
/*  40 */     TEQuern te = (TEQuern)world.func_147438_o(x, y, z);
/*     */ 
/*     */     
/*  43 */     Boolean hit = Boolean.valueOf(((side == 1 && hitX >= 0.7D && hitX <= 90.0F && hitZ >= 0.7D && hitZ <= 0.9D) || (side == 5 && hitZ >= 0.8D && hitZ <= 0.99D && hitY >= 0.85D)));
/*     */ 
/*     */     
/*  46 */     if (!world.field_72995_K) {
/*     */       
/*  48 */       if (!te.shouldRotate && hit.booleanValue() && te.storage[2] != null)
/*     */       {
/*  50 */         te.shouldRotate = true;
/*  51 */         world.func_147471_g(te.field_145851_c, te.field_145848_d, te.field_145849_e);
/*  52 */         world.func_72908_a(x, y, z, "terrafirmacraft:quern.stonedrag", 1.0F, 1.0F);
/*  53 */         entityplayer.func_71029_a((StatBase)TFC_Achievements.achQuern);
/*     */       }
/*  55 */       else if ((!te.shouldRotate && !hit.booleanValue()) || te.storage[2] == null)
/*     */       {
/*  57 */         entityplayer.openGui(TerraFirmaCraft.instance, 33, world, x, y, z);
/*     */       }
/*     */     
/*  60 */     } else if (!te.shouldRotate && hit.booleanValue() && te.hasQuern) {
/*     */       
/*  62 */       te.shouldRotate = true;
/*     */     } 
/*  64 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IIcon func_149691_a(int i, int j) {
/*  70 */     if (i == 0 || (i == 1 && j == 1))
/*  71 */       return this.quernTop1; 
/*  72 */     if (i == 1 && j == 0)
/*  73 */       return this.quernTop2; 
/*  74 */     return this.quernBase;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149651_a(IIconRegister registerer) {
/*  80 */     this.quernBase = registerer.func_94245_a("terrafirmacraft:devices/Quern Base");
/*  81 */     this.quernTop1 = registerer.func_94245_a("terrafirmacraft:devices/Quern Top 1");
/*  82 */     this.quernTop2 = registerer.func_94245_a("terrafirmacraft:devices/Quern Top 2");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canBeReplacedByLeaves(IBlockAccess w, int x, int y, int z) {
/*  88 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/*  94 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/* 100 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/* 106 */     return TFCBlocks.quernRenderId;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_149646_a(IBlockAccess access, int x, int y, int z, int side) {
/* 113 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public AxisAlignedBB func_149668_a(World world, int x, int y, int z) {
/* 119 */     return AxisAlignedBB.func_72330_a(x, y, z, (x + 1), y + 0.825D, (z + 1));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public AxisAlignedBB func_149633_g(World world, int x, int y, int z) {
/* 125 */     return AxisAlignedBB.func_72330_a(x, y, z, (x + 1), y + 0.825D, (z + 1));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public TileEntity func_149915_a(World world, int var2) {
/* 131 */     return (TileEntity)new TEQuern();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\Devices\BlockQuern.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
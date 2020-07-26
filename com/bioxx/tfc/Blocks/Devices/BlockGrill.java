/*     */ package com.bioxx.tfc.Blocks.Devices;
/*     */ 
/*     */ import com.bioxx.tfc.Blocks.BlockTerraContainer;
/*     */ import com.bioxx.tfc.Core.TFCTabs;
/*     */ import com.bioxx.tfc.Core.TFC_Textures;
/*     */ import com.bioxx.tfc.TerraFirmaCraft;
/*     */ import com.bioxx.tfc.TileEntities.TEGrill;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockGrill
/*     */   extends BlockTerraContainer
/*     */ {
/*     */   public BlockGrill() {
/*  30 */     super(Material.field_151573_f);
/*  31 */     func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.05F, 1.0F);
/*  32 */     func_149647_a(TFCTabs.TFC_DEVICES);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149727_a(World world, int x, int y, int z, EntityPlayer entityplayer, int side, float hitX, float hitY, float hitZ) {
/*  38 */     super.func_149727_a(world, x, y, z, entityplayer, side, hitX, hitY, hitZ);
/*  39 */     if (entityplayer.field_71071_by.func_70448_g() != null && entityplayer.field_71071_by.func_70448_g().func_77973_b() instanceof com.bioxx.tfc.Items.ItemBlocks.ItemMetalTrapDoor) {
/*  40 */       return false;
/*     */     }
/*  42 */     TEGrill te = (TEGrill)world.func_147438_o(x, y, z);
/*  43 */     int meta = world.func_72805_g(x, y, z);
/*     */     
/*  45 */     if (isGrillOpen(meta) || (entityplayer.func_70093_af() && te.isEmpty())) {
/*     */       
/*  47 */       world.func_72921_c(x, y, z, meta ^ 0x4, 2);
/*  48 */       world.func_72889_a(entityplayer, 1003, x, y, z, 0);
/*  49 */       return true;
/*     */     } 
/*     */ 
/*     */     
/*  53 */     entityplayer.openGui(TerraFirmaCraft.instance, 43, world, x, y, z);
/*  54 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TileEntity func_149915_a(World var1, int var2) {
/*  61 */     return (TileEntity)new TEGrill();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/*  67 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isReplaceable(IBlockAccess world, int x, int y, int z) {
/*  73 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AxisAlignedBB func_149668_a(World world, int x, int y, int z) {
/*  83 */     func_149719_a((IBlockAccess)world, x, y, z);
/*  84 */     return super.func_149668_a(world, x, y, z);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MovingObjectPosition func_149731_a(World par1World, int par2, int par3, int par4, Vec3 par5Vec3, Vec3 par6Vec3) {
/*  94 */     func_149719_a((IBlockAccess)par1World, par2, par3, par4);
/*  95 */     return super.func_149731_a(par1World, par2, par3, par4, par5Vec3, par6Vec3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149719_a(IBlockAccess access, int x, int y, int z) {
/* 105 */     if (access.func_147438_o(x, y, z) != null && access.func_147438_o(x, y, z) instanceof TEGrill) {
/* 106 */       setBlockBoundsForBlockRender(access.func_72805_g(x, y, z), ((TEGrill)access.func_147438_o(x, y, z)).data);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149655_b(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
/* 112 */     return !isGrillOpen(par1IBlockAccess.func_72805_g(par2, par3, par4));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isGrillOpen(int meta) {
/* 117 */     return ((meta & 0x4) != 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setBlockBoundsForBlockRender(int meta, int data) {
/* 122 */     float f = 0.05F;
/* 123 */     int side = data & 0x7;
/* 124 */     int hinge = data >> 4;
/* 125 */     float fx = 0.0F, fy = 0.0F, fz = 0.0F, fx2 = 1.0F, fy2 = 1.0F, fz2 = 1.0F;
/*     */     
/* 127 */     if (isGrillOpen(meta)) {
/*     */       
/* 129 */       if (hinge == 0) {
/*     */         
/* 131 */         switch (side) {
/*     */ 
/*     */           
/*     */           case 0:
/*     */           case 1:
/*     */           case 2:
/*     */           case 3:
/* 138 */             fx2 = f;
/*     */             break;
/*     */ 
/*     */           
/*     */           case 4:
/*     */           case 5:
/* 144 */             fy2 = f;
/*     */             break;
/*     */           
/*     */           default:
/* 148 */             fx2 = f;
/*     */             break;
/*     */         } 
/*     */       
/* 152 */       } else if (hinge == 1) {
/*     */         
/* 154 */         switch (side) {
/*     */ 
/*     */           
/*     */           case 2:
/*     */           case 3:
/* 159 */             fy2 = f;
/*     */             break;
/*     */           
/*     */           default:
/* 163 */             fz2 = f;
/*     */             break;
/*     */         } 
/*     */       
/* 167 */       } else if (hinge == 2) {
/*     */         
/* 169 */         switch (side) {
/*     */ 
/*     */           
/*     */           case 4:
/*     */           case 5:
/* 174 */             fy = 1.0F - f;
/*     */             break;
/*     */           
/*     */           default:
/* 178 */             fx = 1.0F - f;
/*     */             break;
/*     */         } 
/*     */       
/* 182 */       } else if (hinge == 3) {
/*     */         
/* 184 */         switch (side) {
/*     */ 
/*     */           
/*     */           case 2:
/*     */           case 3:
/* 189 */             fy = 1.0F - f;
/*     */             break;
/*     */ 
/*     */           
/*     */           case 4:
/*     */           case 5:
/* 195 */             fz = 1.0F - f;
/*     */             break;
/*     */           
/*     */           default:
/* 199 */             fz = 1.0F - f;
/*     */             break;
/*     */         } 
/*     */       
/*     */       } 
/* 204 */       func_149676_a(fx, fy, fz, fx2, fy2, fz2);
/*     */     } else {
/*     */       
/* 207 */       func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.05F, 1.0F);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister iconRegisterer) {
/* 219 */     this.field_149761_L = iconRegisterer.func_94245_a("terrafirmacraft:devices/Grill Wrought Iron");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149691_a(int side, int meta) {
/* 226 */     if (meta == 0) {
/*     */       
/* 228 */       if (side == 0 || side == 1)
/*     */       {
/* 230 */         return this.field_149761_L;
/*     */       }
/* 232 */       return TFC_Textures.sheetWroughtIron;
/*     */     } 
/* 234 */     return this.field_149761_L;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/* 240 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_149645_b() {
/* 247 */     return TFCBlocks.grillRenderId;
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_149646_a(IBlockAccess par1iBlockAccess, int par2, int par3, int par4, int par5) {
/* 253 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public AxisAlignedBB func_149633_g(World world, int x, int y, int z) {
/* 263 */     func_149719_a((IBlockAccess)world, x, y, z);
/* 264 */     return super.func_149633_g(world, x, y, z);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\Devices\BlockGrill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
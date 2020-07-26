/*     */ package com.bioxx.tfc.Blocks;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFCTabs;
/*     */ import com.bioxx.tfc.Core.TFC_Textures;
/*     */ import com.bioxx.tfc.TileEntities.TEMetalTrapDoor;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.particle.EffectRenderer;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ public class BlockMetalTrapDoor
/*     */   extends BlockTerraContainer
/*     */ {
/*     */   public IIcon[] icons;
/*  34 */   public static String[] metalNames = new String[] { "Bismuth", "Bismuth Bronze", "Black Bronze", "Black Steel", "Blue Steel", "Brass", "Bronze", "Copper", "Gold", "Wrought Iron", "Lead", "Nickel", "Pig Iron", "Platinum", "Red Steel", "Rose Gold", "Silver", "Steel", "Sterling Silver", "Tin", "Zinc" };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BlockMetalTrapDoor() {
/*  40 */     super(Material.field_151573_f);
/*     */ 
/*     */     
/*  43 */     func_149676_a(0.0F, 0.0F, 0.0F, 0.001F, 0.001F, 0.001F);
/*  44 */     func_149647_a(TFCTabs.TFC_DEVICES);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/*  50 */     return TFCBlocks.metalTrapDoorRenderId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149666_a(Item par1, CreativeTabs par2CreativeTabs, List<ItemStack> list) {
/*  60 */     for (int i = 0; i < metalNames.length; i++)
/*     */     {
/*     */       
/*  63 */       list.add(new ItemStack((Block)this, 1, i + (i << 5)));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public TileEntity func_149915_a(World var1, int var2) {
/*  70 */     return (TileEntity)new TEMetalTrapDoor();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/*  81 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/*  91 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149655_b(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
/*  97 */     return !isTrapdoorOpen(par1IBlockAccess.func_72805_g(par2, par3, par4));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public AxisAlignedBB func_149633_g(World world, int x, int y, int z) {
/* 107 */     func_149719_a((IBlockAccess)world, x, y, z);
/* 108 */     return super.func_149633_g(world, x, y, z);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AxisAlignedBB func_149668_a(World world, int x, int y, int z) {
/* 118 */     func_149719_a((IBlockAccess)world, x, y, z);
/* 119 */     return super.func_149668_a(world, x, y, z);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149719_a(IBlockAccess access, int x, int y, int z) {
/* 129 */     if (access.func_147438_o(x, y, z) != null && access.func_147438_o(x, y, z) instanceof TEMetalTrapDoor) {
/* 130 */       setBlockBoundsForBlockRender(access.func_72805_g(x, y, z), ((TEMetalTrapDoor)access.func_147438_o(x, y, z)).data);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149683_g() {
/* 139 */     float f = 0.125F;
/* 140 */     func_149676_a(0.0F, 0.5F - f / 2.0F, 0.0F, 1.0F, 0.5F + f / 2.0F, 1.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setBlockBoundsForBlockRender(int meta, int data) {
/* 145 */     float f = 0.125F;
/* 146 */     int side = data & 0x7;
/* 147 */     int hinge = data >> 4;
/* 148 */     float fx = 0.0F;
/* 149 */     float fy = 0.0F;
/* 150 */     float fz = 0.0F;
/* 151 */     float fx2 = 1.0F;
/* 152 */     float fy2 = 1.0F;
/* 153 */     float fz2 = 1.0F;
/*     */     
/* 155 */     if (isTrapdoorOpen(meta)) {
/*     */       
/* 157 */       if (hinge == 0) {
/*     */         
/* 159 */         switch (side) {
/*     */ 
/*     */           
/*     */           case 0:
/*     */           case 1:
/*     */           case 2:
/*     */           case 3:
/* 166 */             fx2 = f;
/*     */             break;
/*     */ 
/*     */           
/*     */           case 4:
/*     */           case 5:
/* 172 */             fy2 = f;
/*     */             break;
/*     */           
/*     */           default:
/* 176 */             fx2 = f;
/*     */             break;
/*     */         } 
/*     */       
/* 180 */       } else if (hinge == 1) {
/*     */         
/* 182 */         switch (side) {
/*     */ 
/*     */           
/*     */           case 2:
/*     */           case 3:
/* 187 */             fy2 = f;
/*     */             break;
/*     */           
/*     */           default:
/* 191 */             fz2 = f;
/*     */             break;
/*     */         } 
/*     */       
/* 195 */       } else if (hinge == 2) {
/*     */         
/* 197 */         switch (side) {
/*     */ 
/*     */           
/*     */           case 4:
/*     */           case 5:
/* 202 */             fy = 1.0F - f;
/*     */             break;
/*     */           
/*     */           default:
/* 206 */             fx = 1.0F - f;
/*     */             break;
/*     */         } 
/*     */       
/* 210 */       } else if (hinge == 3) {
/*     */         
/* 212 */         switch (side) {
/*     */ 
/*     */           
/*     */           case 2:
/*     */           case 3:
/* 217 */             fy = 1.0F - f;
/*     */             break;
/*     */ 
/*     */           
/*     */           case 4:
/*     */           case 5:
/* 223 */             fz = 1.0F - f;
/*     */             break;
/*     */           
/*     */           default:
/* 227 */             fz = 1.0F - f;
/*     */             break;
/*     */         } 
/*     */ 
/*     */ 
/*     */       
/*     */       } 
/* 234 */     } else if (side == 0) {
/*     */       
/* 236 */       fy = 1.0F - f;
/*     */     }
/* 238 */     else if (side == 1) {
/*     */       
/* 240 */       fy2 = f;
/*     */     }
/* 242 */     else if (side == 2) {
/*     */       
/* 244 */       fz = 1.0F - f;
/*     */     }
/* 246 */     else if (side == 3) {
/*     */       
/* 248 */       fz2 = f;
/*     */     }
/* 250 */     else if (side == 4) {
/*     */       
/* 252 */       fx = 1.0F - f;
/*     */     }
/* 254 */     else if (side == 5) {
/*     */       
/* 256 */       fx2 = f;
/*     */     } 
/*     */ 
/*     */     
/* 260 */     func_149676_a(fx, fy, fz, fx2, fy2, fz2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149699_a(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Item func_149650_a(int metadata, Random rand, int fortune) {
/* 274 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149727_a(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
/* 285 */     int i1 = par1World.func_72805_g(par2, par3, par4);
/* 286 */     par1World.func_72921_c(par2, par3, par4, i1 ^ 0x4, 2);
/* 287 */     par1World.func_72889_a(par5EntityPlayer, 1003, par2, par3, par4, 0);
/* 288 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149725_f(World world, int i, int j, int k, int meta) {
/* 294 */     if (!world.field_72995_K) {
/*     */       
/* 296 */       TEMetalTrapDoor te = (TEMetalTrapDoor)world.func_147438_o(i, j, k);
/* 297 */       if (te != null && te.sheetStack != null) {
/*     */         
/* 299 */         EntityItem ei = new EntityItem(world, i, j, k, te.sheetStack);
/* 300 */         world.func_72838_d((Entity)ei);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MovingObjectPosition func_149731_a(World par1World, int par2, int par3, int par4, Vec3 par5Vec3, Vec3 par6Vec3) {
/* 313 */     func_149719_a((IBlockAccess)par1World, par2, par3, par4);
/* 314 */     return super.func_149731_a(par1World, par2, par3, par4, par5Vec3, par6Vec3);
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isTrapdoorOpen(int par0) {
/* 319 */     return ((par0 & 0x4) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149651_a(IIconRegister registerer) {
/* 325 */     this.icons = new IIcon[metalNames.length];
/* 326 */     for (int i = 0; i < this.icons.length; i++) {
/* 327 */       this.icons[i] = registerer.func_94245_a("terrafirmacraft:metal/" + metalNames[i] + " Trap Door");
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149673_e(IBlockAccess access, int i, int j, int k, int meta) {
/* 334 */     TEMetalTrapDoor te = (TEMetalTrapDoor)access.func_147438_o(i, j, k);
/* 335 */     if (te != null && te.sheetStack != null) {
/* 336 */       return this.icons[te.sheetStack.func_77960_j() & 0x1F];
/*     */     }
/* 338 */     return TFC_Textures.invisibleTexture;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149691_a(int side, int meta) {
/* 345 */     return this.icons[meta & 0x1F];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean addHitEffects(World worldObj, MovingObjectPosition target, EffectRenderer effectRenderer) {
/* 352 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean addDestroyEffects(World world, int x, int y, int z, int meta, EffectRenderer effectRenderer) {
/* 359 */     return (world.func_147439_a(x, y, z) == this);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\BlockMetalTrapDoor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
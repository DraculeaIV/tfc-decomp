/*     */ package com.bioxx.tfc.Blocks;
/*     */ 
/*     */ import com.bioxx.tfc.Core.CollisionRayTraceStandard;
/*     */ import com.bioxx.tfc.Core.TFC_Textures;
/*     */ import com.bioxx.tfc.TerraFirmaCraft;
/*     */ import com.bioxx.tfc.TileEntities.TEMetalSheet;
/*     */ import com.bioxx.tfc.api.Interfaces.ICustomCollision;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.particle.EffectRenderer;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.Explosion;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.util.ForgeDirection;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockMetalSheet
/*     */   extends BlockTerraContainer
/*     */   implements ICustomCollision
/*     */ {
/*     */   public IIcon[] icons;
/*  38 */   public String[] metalNames = new String[] { "Bismuth", "Bismuth Bronze", "Black Bronze", "Black Steel", "Blue Steel", "Brass", "Bronze", "Copper", "Gold", "Wrought Iron", "Lead", "Nickel", "Pig Iron", "Platinum", "Red Steel", "Rose Gold", "Silver", "Steel", "Sterling Silver", "Tin", "Zinc" };
/*     */ 
/*     */ 
/*     */   
/*     */   public BlockMetalSheet() {
/*  43 */     super(Material.field_151573_f);
/*  44 */     this.icons = new IIcon[this.metalNames.length];
/*  45 */     func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Item func_149650_a(int par1, Random par2Random, int par3) {
/*  51 */     return Item.func_150899_d(0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float func_149712_f(World world, int x, int y, int z) {
/*  58 */     return this.field_149782_v;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_149646_a(IBlockAccess blockAccess, int x, int y, int z, int side) {
/*  65 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149725_f(World world, int i, int j, int k, int meta) {
/*  71 */     if (world.func_147438_o(i, j, k) instanceof TEMetalSheet) {
/*     */       
/*  73 */       TEMetalSheet te = (TEMetalSheet)world.func_147438_o(i, j, k);
/*  74 */       if (te.sheetStack != null) {
/*     */         
/*  76 */         int stack = 0;
/*  77 */         if (te.topExists()) stack++; 
/*  78 */         if (te.bottomExists()) stack++; 
/*  79 */         if (te.northExists()) stack++; 
/*  80 */         if (te.southExists()) stack++; 
/*  81 */         if (te.eastExists()) stack++; 
/*  82 */         if (te.westExists()) stack++; 
/*  83 */         te.sheetStack.field_77994_a = stack;
/*  84 */         EntityItem ei = new EntityItem(world, i, j, k, te.sheetStack);
/*  85 */         world.func_72838_d((Entity)ei);
/*     */       } else {
/*     */         
/*  88 */         TerraFirmaCraft.LOG.error("Metal sheet block (" + i + ", " + j + ", " + k + ") being broken contains null sheetstack. Please report this on the forums.");
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void onBlockExploded(World world, int i, int j, int k, Explosion explosion) {
/*  95 */     TEMetalSheet te = (TEMetalSheet)world.func_147438_o(i, j, k);
/*  96 */     if (te != null) {
/*  97 */       te.clearSides();
/*     */     }
/*  99 */     super.onBlockExploded(world, i, j, k, explosion);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/* 105 */     return TFCBlocks.metalsheetRenderId;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/* 111 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/* 117 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149651_a(IIconRegister registerer) {
/* 123 */     for (int i = 0; i < this.icons.length; i++) {
/* 124 */       this.icons[i] = registerer.func_94245_a("terrafirmacraft:metal/" + this.metalNames[i]);
/*     */     }
/* 126 */     TFC_Textures.sheetBismuth = this.icons[0];
/* 127 */     TFC_Textures.sheetBismuthBronze = this.icons[1];
/* 128 */     TFC_Textures.sheetBlackBronze = this.icons[2];
/* 129 */     TFC_Textures.sheetBlackSteel = this.icons[3];
/* 130 */     TFC_Textures.sheetBlueSteel = this.icons[4];
/* 131 */     TFC_Textures.sheetBrass = this.icons[5];
/* 132 */     TFC_Textures.sheetBronze = this.icons[6];
/* 133 */     TFC_Textures.sheetCopper = this.icons[7];
/* 134 */     TFC_Textures.sheetGold = this.icons[8];
/* 135 */     TFC_Textures.sheetWroughtIron = this.icons[9];
/* 136 */     TFC_Textures.sheetLead = this.icons[10];
/* 137 */     TFC_Textures.sheetNickel = this.icons[11];
/* 138 */     TFC_Textures.sheetPigIron = this.icons[12];
/* 139 */     TFC_Textures.sheetPlatinum = this.icons[13];
/* 140 */     TFC_Textures.sheetRedSteel = this.icons[14];
/* 141 */     TFC_Textures.sheetRoseGold = this.icons[15];
/* 142 */     TFC_Textures.sheetSilver = this.icons[16];
/* 143 */     TFC_Textures.sheetSteel = this.icons[17];
/* 144 */     TFC_Textures.sheetSterlingSilver = this.icons[18];
/* 145 */     TFC_Textures.sheetTin = this.icons[19];
/* 146 */     TFC_Textures.sheetZinc = this.icons[20];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public TileEntity func_149915_a(World var1, int var2) {
/* 152 */     return (TileEntity)new TEMetalSheet();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IIcon func_149691_a(int side, int meta) {
/* 158 */     if (meta >= 0 && meta < this.icons.length)
/* 159 */       return this.icons[meta]; 
/* 160 */     return this.icons[19];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149673_e(IBlockAccess access, int i, int j, int k, int meta) {
/* 167 */     TEMetalSheet te = (TEMetalSheet)access.func_147438_o(i, j, k);
/* 168 */     if (te != null) {
/* 169 */       return this.icons[te.metalID];
/*     */     }
/* 171 */     return this.icons[19];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addCollisionBoxesToList(World world, int i, int j, int k, List<Object[]> list) {
/* 178 */     TEMetalSheet te = (TEMetalSheet)world.func_147438_o(i, j, k);
/* 179 */     double f0 = 0.0625D;
/* 180 */     double f1 = 0.9375D;
/* 181 */     double yMax = 1.0D;
/* 182 */     double yMin = 0.0D;
/*     */     
/* 184 */     if (te.topExists())
/* 185 */       list.add(new Object[] { AxisAlignedBB.func_72330_a(0.0D, f1, 0.0D, 1.0D, 1.0D, 1.0D), Integer.valueOf(0) }); 
/* 186 */     if (te.bottomExists())
/* 187 */       list.add(new Object[] { AxisAlignedBB.func_72330_a(0.0D, 0.0D, 0.0D, 1.0D, f0, 1.0D), Integer.valueOf(1) }); 
/* 188 */     if (te.northExists())
/* 189 */       list.add(new Object[] { AxisAlignedBB.func_72330_a(0.0D, yMin, 0.0D, 1.0D, yMax, f0), Integer.valueOf(2) }); 
/* 190 */     if (te.southExists())
/* 191 */       list.add(new Object[] { AxisAlignedBB.func_72330_a(0.0D, yMin, f1, 1.0D, yMax, 1.0D), Integer.valueOf(3) }); 
/* 192 */     if (te.eastExists())
/* 193 */       list.add(new Object[] { AxisAlignedBB.func_72330_a(0.0D, yMin, 0.0D, f0, yMax, 1.0D), Integer.valueOf(4) }); 
/* 194 */     if (te.westExists()) {
/* 195 */       list.add(new Object[] { AxisAlignedBB.func_72330_a(f1, yMin, 0.0D, 1.0D, yMax, 1.0D), Integer.valueOf(5) });
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149743_a(World world, int i, int j, int k, AxisAlignedBB aabb, List<AxisAlignedBB> list, Entity entity) {
/* 202 */     ArrayList<Object[]> l = new ArrayList();
/* 203 */     addCollisionBoxesToList(world, i, j, k, l);
/* 204 */     for (Object[] o : l) {
/*     */       
/* 206 */       AxisAlignedBB a = (AxisAlignedBB)o[0];
/* 207 */       if (a != null && aabb.func_72326_a(a)) {
/* 208 */         list.add(a);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public MovingObjectPosition func_149731_a(World world, int x, int y, int z, Vec3 player, Vec3 view) {
/* 215 */     return CollisionRayTraceStandard.collisionRayTrace(this, world, x, y, z, player, view);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149747_d(IBlockAccess world, int x, int y, int z, int side) {
/* 221 */     TEMetalSheet te = (TEMetalSheet)world.func_147438_o(x, y, z);
/* 222 */     switch (side) {
/*     */       case 0:
/* 224 */         return te.bottomExists();
/* 225 */       case 1: return te.topExists();
/* 226 */       case 2: return te.northExists();
/* 227 */       case 3: return te.southExists();
/* 228 */       case 4: return te.eastExists();
/* 229 */       case 5: return te.westExists();
/* 230 */     }  return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSideSolid(IBlockAccess world, int x, int y, int z, ForgeDirection side) {
/* 237 */     TEMetalSheet te = (TEMetalSheet)world.func_147438_o(x, y, z);
/* 238 */     switch (side) {
/*     */       case DOWN:
/* 240 */         return te.bottomExists();
/* 241 */       case UP: return te.topExists();
/* 242 */       case NORTH: return te.northExists();
/* 243 */       case SOUTH: return te.southExists();
/* 244 */       case EAST: return te.eastExists();
/* 245 */       case WEST: return te.westExists();
/* 246 */     }  return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean addHitEffects(World worldObj, MovingObjectPosition target, EffectRenderer effectRenderer) {
/* 279 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean addDestroyEffects(World world, int x, int y, int z, int meta, EffectRenderer effectRenderer) {
/* 286 */     return (world.func_147439_a(x, y, z) == this);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\BlockMetalSheet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
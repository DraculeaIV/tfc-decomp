/*     */ package com.bioxx.tfc.Blocks;
/*     */ 
/*     */ import com.bioxx.tfc.Core.CollisionRayTraceStandard;
/*     */ import com.bioxx.tfc.TileEntities.TEWoodConstruct;
/*     */ import com.bioxx.tfc.api.Interfaces.ICustomCollision;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.Explosion;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockWoodConstruct
/*     */   extends BlockTerraContainer
/*     */   implements ICustomCollision
/*     */ {
/*     */   public BlockWoodConstruct() {
/*  33 */     super(Material.field_151575_d);
/*  34 */     func_149676_a(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public TileEntity func_149915_a(World var1, int var2) {
/*  40 */     return (TileEntity)new TEWoodConstruct();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/*  46 */     return TFCBlocks.woodConstructRenderId;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149655_b(IBlockAccess par1IBlockAccess, int i, int j, int k) {
/*  52 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149651_a(IIconRegister iconRegisterer) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IIcon func_149691_a(int i, int j) {
/*  64 */     return TFCBlocks.planks.func_149691_a(i, j);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/*  70 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/*  76 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
/*  82 */     List<ItemStack> ret = new ArrayList<ItemStack>();
/*     */     
/*  84 */     if (!world.field_72995_K && (TEWoodConstruct)world.func_147438_o(x, y, z) != null) {
/*     */       
/*  86 */       TEWoodConstruct te = (TEWoodConstruct)world.func_147438_o(x, y, z);
/*  87 */       ret = te.getDrops();
/*     */     } 
/*  89 */     return (ArrayList<ItemStack>)ret;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149681_a(World world, int x, int y, int z, int meta, EntityPlayer player) {
/*  95 */     ArrayList<ItemStack> out = getDrops(world, x, y, z, meta, 0);
/*  96 */     for (ItemStack is : out)
/*     */     {
/*  98 */       world.func_72838_d((Entity)new EntityItem(world, x + 0.5D, y + 0.5D, z + 0.5D, is));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149659_a(Explosion ex) {
/* 105 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_149646_a(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5) {
/* 112 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149743_a(World world, int i, int j, int k, AxisAlignedBB aabb, List<AxisAlignedBB> list, Entity entity) {
/* 118 */     ArrayList<Object[]> alist = new ArrayList();
/* 119 */     addCollisionBoxesToList(world, i, j, k, alist);
/* 120 */     for (Object[] obj : alist) {
/*     */       
/* 122 */       AxisAlignedBB plankAABB = (AxisAlignedBB)obj[0];
/* 123 */       plankAABB.field_72340_a += i; plankAABB.field_72336_d += i;
/* 124 */       plankAABB.field_72338_b += j; plankAABB.field_72337_e += j;
/* 125 */       plankAABB.field_72339_c += k; plankAABB.field_72334_f += k;
/* 126 */       if (aabb.func_72326_a(plankAABB))
/*     */       {
/* 128 */         list.add(plankAABB);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public MovingObjectPosition func_149731_a(World world, int x, int y, int z, Vec3 player, Vec3 view) {
/* 136 */     return CollisionRayTraceStandard.collisionRayTrace(this, world, x, y, z, player, view);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addCollisionBoxesToList(World world, int i, int j, int k, List<Object[]> list) {
/* 142 */     TEWoodConstruct te = (TEWoodConstruct)world.func_147438_o(i, j, k);
/*     */     
/* 144 */     int d = TEWoodConstruct.plankDetailLevel;
/* 145 */     int dd = TEWoodConstruct.plankDetailLevel * TEWoodConstruct.plankDetailLevel;
/*     */     
/* 147 */     float div = 1.0F / d;
/*     */     
/* 149 */     for (int x = 0; x < dd; x++) {
/*     */       
/* 151 */       if (te.data.get(x)) {
/*     */         
/* 153 */         float minX = 0.0F;
/* 154 */         float maxX = 1.0F;
/* 155 */         float minY = div * (x & 0x7);
/* 156 */         float maxY = minY + div;
/* 157 */         float minZ = div * (x >> 3);
/* 158 */         float maxZ = minZ + div;
/* 159 */         list.add(new Object[] { AxisAlignedBB.func_72330_a(minX, minY, minZ, maxX, maxY, maxZ) });
/*     */       } 
/*     */     } 
/*     */     
/* 163 */     for (int y = 0; y < dd; y++) {
/*     */       
/* 165 */       if (te.data.get(y + dd)) {
/*     */         
/* 167 */         float minX = div * (y & 0x7);
/* 168 */         float maxX = minX + div;
/* 169 */         float minY = 0.0F;
/* 170 */         float maxY = 1.0F;
/* 171 */         float minZ = div * (y >> 3);
/* 172 */         float maxZ = minZ + div;
/* 173 */         list.add(new Object[] { AxisAlignedBB.func_72330_a(minX, minY, minZ, maxX, maxY, maxZ) });
/*     */       } 
/*     */     } 
/*     */     
/* 177 */     for (int z = 0; z < dd; z++) {
/*     */       
/* 179 */       if (te.data.get(z + dd * 2)) {
/*     */         
/* 181 */         float minX = div * (z & 0x7);
/* 182 */         float maxX = minX + div;
/* 183 */         float minY = div * (z >> 3);
/* 184 */         float maxY = minY + div;
/* 185 */         float minZ = 0.0F;
/* 186 */         float maxZ = 1.0F;
/* 187 */         list.add(new Object[] { AxisAlignedBB.func_72330_a(minX, minY, minZ, maxX, maxY, maxZ) });
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\BlockWoodConstruct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
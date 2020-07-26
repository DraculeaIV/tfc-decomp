/*     */ package com.bioxx.tfc.Blocks;
/*     */ 
/*     */ import com.bioxx.tfc.Core.CollisionRayTraceDetailed;
/*     */ import com.bioxx.tfc.Core.Player.PlayerInfo;
/*     */ import com.bioxx.tfc.Core.Player.PlayerManagerTFC;
/*     */ import com.bioxx.tfc.Handlers.Network.AbstractPacket;
/*     */ import com.bioxx.tfc.TileEntities.TEDetailed;
/*     */ import com.bioxx.tfc.TileEntities.TEWoodConstruct;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import com.bioxx.tfc.api.TFCOptions;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.particle.EffectRenderer;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.util.ForgeDirection;
/*     */ 
/*     */ public class BlockDetailed
/*     */   extends BlockPartial
/*     */ {
/*     */   public static int lockX;
/*     */   public static int lockY;
/*     */   public static int lockZ;
/*     */   public int xSelected;
/*     */   public int ySelected;
/*     */   public int zSelected;
/*     */   public int side;
/*     */   
/*     */   public BlockDetailed() {
/*  47 */     super(Material.field_151576_e);
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
/* 300 */     this.xSelected = -10; this.ySelected = -10; this.zSelected = -10; this.side = -1;
/*     */   } public int func_149645_b() { return TFCBlocks.detailedRenderId; } @SideOnly(Side.CLIENT) public boolean addDestroyEffects(World world, int x, int y, int z, int meta, EffectRenderer effectRenderer) { return true; } @SideOnly(Side.CLIENT) public boolean addHitEffects(World worldObj, MovingObjectPosition target, EffectRenderer effectRenderer) { return true; } public boolean func_149655_b(IBlockAccess bAccess, int i, int j, int k) { return true; }
/*     */   public void func_149651_a(IIconRegister iconRegisterer) {}
/*     */   public IIcon func_149673_e(IBlockAccess bAccess, int x, int y, int z, int side) { TEDetailed te = (TEDetailed)bAccess.func_147438_o(x, y, z); return te.func_145838_q().func_149691_a(side, te.metaID); }
/*     */   public TileEntity func_149915_a(World var1, int var2) { return (TileEntity)new TEDetailed(); }
/* 305 */   public MovingObjectPosition func_149731_a(World world, int x, int y, int z, Vec3 player, Vec3 view) { TEDetailed te = (TEDetailed)world.func_147438_o(x, y, z);
/*     */     
/* 307 */     player = player.func_72441_c(-x, -y, -z);
/* 308 */     view = view.func_72441_c(-x, -y, -z);
/* 309 */     if (te == null) {
/* 310 */       return null;
/*     */     }
/* 312 */     List<Object[]> returns = new ArrayList();
/*     */ 
/*     */     
/* 315 */     returns = CollisionRayTraceDetailed.rayTraceSubBlocks(this, player, view, x, y, z, returns, te.data, te);
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
/* 327 */     if (!returns.isEmpty()) {
/* 328 */       Object[] min = null;
/* 329 */       double distMin = 0.0D;
/* 330 */       for (Object[] ret : returns) {
/*     */         
/* 332 */         double dist = ((Double)ret[2]).doubleValue();
/* 333 */         if (min == null || dist < distMin) {
/*     */           
/* 335 */           distMin = dist;
/* 336 */           min = ret;
/*     */         } 
/*     */       } 
/* 339 */       if (min != null) {
/*     */         
/* 341 */         this.side = ((Byte)min[1]).byteValue();
/* 342 */         this.xSelected = ((Integer)min[3]).intValue();
/* 343 */         this.ySelected = ((Integer)min[4]).intValue();
/* 344 */         this.zSelected = ((Integer)min[5]).intValue();
/*     */         
/* 346 */         int index = (this.xSelected * 8 + this.zSelected) * 8 + this.ySelected;
/*     */         
/* 348 */         if (index >= 0 && te.data.get(index)) {
/*     */           
/* 350 */           int d = TEWoodConstruct.plankDetailLevel;
/*     */           
/* 352 */           float div = 1.0F / d;
/*     */           
/* 354 */           float minX = x + this.xSelected * div;
/* 355 */           float maxX = minX + div;
/* 356 */           float minY = y + this.ySelected * div;
/* 357 */           float maxY = minY + div;
/* 358 */           float minZ = z + this.zSelected * div;
/* 359 */           float maxZ = minZ + div;
/*     */           
/* 361 */           func_149676_a(minX, minY, minZ, maxX, maxY, maxZ);
/* 362 */           rayTraceBound(AxisAlignedBB.func_72330_a(minX, minY, minZ, maxX, maxY, maxZ), x, y, z, player, view);
/*     */         } 
/* 364 */         setBlockBoundsBasedOnSelection((IBlockAccess)world, x, y, z);
/*     */         
/* 366 */         lockX = x; lockY = y; lockZ = z;
/*     */         
/* 368 */         return new MovingObjectPosition(x, y, z, ((Byte)min[1])
/* 369 */             .byteValue(), ((Vec3)min[0])
/* 370 */             .func_72441_c(x, y, z));
/*     */       } 
/*     */     } 
/* 373 */     this.xSelected = -10;
/* 374 */     this.ySelected = -10;
/* 375 */     this.zSelected = -10;
/* 376 */     this.side = -1;
/* 377 */     setBlockBoundsBasedOnSelection((IBlockAccess)world, x, y, z);
/*     */     
/* 379 */     return null; } public boolean func_149662_c() { return false; }
/*     */   public boolean isSideSolid(IBlockAccess world, int x, int y, int z, ForgeDirection side) { if (!TFCOptions.enableSolidDetailed) return false;  if (side == ForgeDirection.UNKNOWN) return false;  int transpCount = TFCOptions.maxRemovedSolidDetailed; if (transpCount < 0 || transpCount >= 64) return false;  TEDetailed te = (TEDetailed)world.func_147438_o(x, y, z); int startX = (side == ForgeDirection.EAST) ? 7 : 0; int endX = (side == ForgeDirection.WEST) ? 1 : 8; int startY = (side == ForgeDirection.UP) ? 7 : 0; int endY = (side == ForgeDirection.DOWN) ? 1 : 8; int startZ = (side == ForgeDirection.SOUTH) ? 7 : 0; int endZ = (side == ForgeDirection.NORTH) ? 1 : 8; for (int subX = startX; subX < endX; subX++) { for (int subY = startY; subY < endY; subY++) { for (int subZ = startZ; subZ < endZ; subZ++) { if (!te.getBlockExists(subX, subY, subZ) && --transpCount < 0)
/*     */             return false;  }  }  }  return true; }
/*     */   public boolean func_149686_d() { return false; }
/*     */   @SideOnly(Side.CLIENT) public boolean func_149646_a(IBlockAccess bAccess, int x, int y, int z, int side) { return true; }
/* 384 */   public void setBlockBoundsBasedOnSelection(IBlockAccess access, int x, int y, int z) { if (this.xSelected == -10)
/*     */     
/* 386 */     { func_149676_a(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F); }
/*     */     
/*     */     else
/*     */     
/* 390 */     { TEDetailed te = (TEDetailed)access.func_147438_o(x, y, z);
/* 391 */       int index = (this.xSelected * 8 + this.zSelected) * 8 + this.ySelected;
/*     */       
/* 393 */       if (index >= 0 && te.data.get(index))
/*     */       
/* 395 */       { int d = 8;
/*     */ 
/*     */ 
/*     */         
/* 399 */         float div = 1.0F / d;
/*     */         
/* 401 */         float minX = this.xSelected * div;
/* 402 */         float maxX = minX + div;
/* 403 */         float minY = this.ySelected * div;
/* 404 */         float maxY = minY + div;
/* 405 */         float minZ = this.zSelected * div;
/* 406 */         float maxZ = minZ + div;
/*     */         
/* 408 */         AxisAlignedBB bound = AxisAlignedBB.func_72330_a(minX, minY, minZ, maxX, maxY, maxZ);
/* 409 */         func_149676_a((float)bound.field_72340_a, (float)bound.field_72338_b, (float)bound.field_72339_c, (float)bound.field_72336_d, (float)bound.field_72337_e, (float)bound.field_72334_f); }  }  }
/*     */   public boolean func_149727_a(World world, int x, int y, int z, EntityPlayer entityplayer, int side, float hitX, float hitY, float hitZ) { boolean hasHammer = false; PlayerInfo pi = PlayerManagerTFC.getInstance().getPlayerInfoFromPlayer(entityplayer); for (int i = 0; i < 9; i++) { if (entityplayer.field_71071_by.field_70462_a[i] != null && entityplayer.field_71071_by.field_70462_a[i].func_77973_b() instanceof com.bioxx.tfc.Items.Tools.ItemHammer) hasHammer = true;  }  if (entityplayer.func_71045_bC() != null && entityplayer.func_71045_bC().func_77973_b() instanceof com.bioxx.tfc.Items.Tools.ItemChisel && hasHammer && world.field_72995_K && pi.lockMatches(x, y, z)) { TEDetailed te = (TEDetailed)world.func_147438_o(x, y, z); lockX = x; lockY = y; lockZ = z; NBTTagCompound nbt = new NBTTagCompound(); nbt.func_74774_a("packetType", (byte)1); nbt.func_74768_a("xSelected", this.xSelected); nbt.func_74768_a("ySelected", this.ySelected); nbt.func_74768_a("zSelected", this.zSelected); te.createDataNBT(nbt); te.broadcastPacketInRange((AbstractPacket)te.createDataPacket(nbt)); }  return false; }
/*     */   public boolean onBlockActivatedServer(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) { int mode = 0; PlayerInfo pi = PlayerManagerTFC.getInstance().getPlayerInfoFromPlayer(player); if (pi != null) mode = pi.chiselMode;  TEDetailed te = (TEDetailed)world.func_147438_o(x, y, z); int hasChisel = -1; int hasHammer = -1; for (int i = 0; i < 9; i++) { if (player.field_71071_by.field_70462_a[i] != null && player.field_71071_by.field_70462_a[i].func_77973_b() instanceof com.bioxx.tfc.Items.Tools.ItemHammer)
/*     */         hasHammer = i;  if (player.field_71071_by.field_70462_a[i] != null && player.field_71071_by.field_70462_a[i].func_77973_b() instanceof com.bioxx.tfc.Items.Tools.ItemChisel)
/*     */         hasChisel = i;  }  if (mode == 1) { int index = -10; if (this.xSelected < 4 && this.ySelected < 4 && this.zSelected < 4)
/*     */         for (int subX = 0; subX < 4; ) { for (int subZ = 0; subZ < 4; ) { for (int subY = 0; subY < 4; subY++) { index = (subX * 8 + subZ) * 8 + subY; deleteBox(world, x, y, z, player, te, index, hasChisel, hasHammer); }  subZ++; }  subX++; }   if (this.xSelected > 3 && this.ySelected < 4 && this.zSelected < 4)
/*     */         for (int subX = 4; subX < 8; ) { for (int subZ = 0; subZ < 4; ) { for (int subY = 0; subY < 4; subY++) { index = (subX * 8 + subZ) * 8 + subY; deleteBox(world, x, y, z, player, te, index, hasChisel, hasHammer); }  subZ++; }  subX++; }   if (this.xSelected > 3 && this.ySelected < 4 && this.zSelected > 3)
/*     */         for (int subX = 4; subX < 8; ) { for (int subZ = 4; subZ < 8; ) { for (int subY = 0; subY < 4; subY++) { index = (subX * 8 + subZ) * 8 + subY; deleteBox(world, x, y, z, player, te, index, hasChisel, hasHammer); }  subZ++; }  subX++; }   if (this.xSelected < 4 && this.ySelected < 4 && this.zSelected > 3)
/*     */         for (int subX = 0; subX < 4; ) { for (int subZ = 4; subZ < 8; ) { for (int subY = 0; subY < 4; subY++) { index = (subX * 8 + subZ) * 8 + subY; deleteBox(world, x, y, z, player, te, index, hasChisel, hasHammer); }  subZ++; }  subX++; }   if (this.xSelected < 4 && this.ySelected > 3 && this.zSelected < 4)
/*     */         for (int subX = 0; subX < 4; ) { for (int subZ = 0; subZ < 4; ) { for (int subY = 4; subY < 8; subY++) { index = (subX * 8 + subZ) * 8 + subY; deleteBox(world, x, y, z, player, te, index, hasChisel, hasHammer); }  subZ++; }  subX++; }   if (this.xSelected > 3 && this.ySelected > 3 && this.zSelected < 4)
/*     */         for (int subX = 4; subX < 8; ) { for (int subZ = 0; subZ < 4; ) { for (int subY = 4; subY < 8; subY++) { index = (subX * 8 + subZ) * 8 + subY; deleteBox(world, x, y, z, player, te, index, hasChisel, hasHammer); }  subZ++; }  subX++; }   if (this.xSelected > 3 && this.ySelected > 3 && this.zSelected > 3)
/*     */         for (int subX = 4; subX < 8; ) { for (int subZ = 4; subZ < 8; ) { for (int subY = 4; subY < 8; subY++) { index = (subX * 8 + subZ) * 8 + subY; deleteBox(world, x, y, z, player, te, index, hasChisel, hasHammer); }  subZ++; }  subX++; }   if (this.xSelected < 4 && this.ySelected > 3 && this.zSelected > 3)
/*     */         for (int subX = 0; subX < 4; ) { for (int subZ = 4; subZ < 8; ) { for (int subY = 4; subY < 8; subY++) { index = (subX * 8 + subZ) * 8 + subY; deleteBox(world, x, y, z, player, te, index, hasChisel, hasHammer); }  subZ++; }  subX++; }   return true; }  if (mode == 3 && this.xSelected != -10) { int index = (this.xSelected * 8 + this.zSelected) * 8 + this.ySelected; if (index >= 0)
/* 422 */         deleteBox(world, x, y, z, player, te, index, hasChisel, hasHammer);  return true; }  return false; } public Object[] rayTraceBound(AxisAlignedBB bound, int i, int j, int k, Vec3 player, Vec3 view) { Vec3 minX = player.func_72429_b(view, bound.field_72340_a);
/* 423 */     Vec3 maxX = player.func_72429_b(view, bound.field_72336_d);
/* 424 */     Vec3 minY = player.func_72435_c(view, bound.field_72338_b);
/* 425 */     Vec3 maxY = player.func_72435_c(view, bound.field_72337_e);
/* 426 */     Vec3 minZ = player.func_72434_d(view, bound.field_72339_c);
/* 427 */     Vec3 maxZ = player.func_72434_d(view, bound.field_72334_f);
/* 428 */     if (!isVecInsideYZBounds(bound, minX))
/* 429 */       minX = null; 
/* 430 */     if (!isVecInsideYZBounds(bound, maxX))
/* 431 */       maxX = null; 
/* 432 */     if (!isVecInsideXZBounds(bound, minY))
/* 433 */       minY = null; 
/* 434 */     if (!isVecInsideXZBounds(bound, maxY))
/* 435 */       maxY = null; 
/* 436 */     if (!isVecInsideXYBounds(bound, minZ))
/* 437 */       minZ = null; 
/* 438 */     if (!isVecInsideXYBounds(bound, maxZ)) {
/* 439 */       maxZ = null;
/*     */     }
/* 441 */     Vec3 tracedBound = null;
/* 442 */     if (minX != null && (tracedBound == null || player.func_72438_d(minX) < player.func_72438_d(tracedBound)))
/* 443 */       tracedBound = minX; 
/* 444 */     if (maxX != null && (tracedBound == null || player.func_72438_d(maxX) < player.func_72438_d(tracedBound)))
/* 445 */       tracedBound = maxX; 
/* 446 */     if (minY != null && (tracedBound == null || player.func_72438_d(minY) < player.func_72438_d(tracedBound)))
/* 447 */       tracedBound = minY; 
/* 448 */     if (maxY != null && (tracedBound == null || player.func_72438_d(maxY) < player.func_72438_d(tracedBound)))
/* 449 */       tracedBound = maxY; 
/* 450 */     if (minZ != null && (tracedBound == null || player.func_72438_d(minZ) < player.func_72438_d(tracedBound)))
/* 451 */       tracedBound = minZ; 
/* 452 */     if (maxZ != null && (tracedBound == null || player.func_72438_d(maxZ) < player.func_72438_d(tracedBound)))
/* 453 */       tracedBound = maxZ; 
/* 454 */     if (tracedBound == null) {
/* 455 */       return null;
/*     */     }
/* 457 */     byte side = -1;
/* 458 */     if (tracedBound == minX)
/* 459 */       side = 4; 
/* 460 */     if (tracedBound == maxX)
/* 461 */       side = 5; 
/* 462 */     if (tracedBound == minY)
/* 463 */       side = 0; 
/* 464 */     if (tracedBound == maxY)
/* 465 */       side = 1; 
/* 466 */     if (tracedBound == minZ)
/* 467 */       side = 2; 
/* 468 */     if (tracedBound == maxZ) {
/* 469 */       side = 3;
/*     */     }
/* 471 */     return new Object[] { tracedBound, Byte.valueOf(side), Double.valueOf(player.func_72438_d(tracedBound)) }; }
/*     */   public void deleteBox(World world, int x, int y, int z, EntityPlayer player, TEDetailed te, int index, int hasChisel, int hasHammer) { te.data.clear(index); te.clearQuad(this.xSelected, this.ySelected, this.zSelected); if (te.isBlockEmpty())
/*     */       world.func_147468_f(x, y, z);  if (player.field_71071_by.field_70462_a[hasChisel] != null)
/*     */       player.field_71071_by.field_70462_a[hasChisel].func_77972_a(1, (EntityLivingBase)player);  NBTTagCompound nbt = new NBTTagCompound(); nbt.func_74774_a("packetType", (byte)0); nbt.func_74768_a("index", index); te.createDataNBT(nbt); te.broadcastPacketInRange((AbstractPacket)te.createDataPacket(nbt)); }
/* 475 */   public void func_149743_a(World world, int i, int j, int k, AxisAlignedBB aabb, List list, Entity entity) { TEDetailed te = (TEDetailed)world.func_147438_o(i, j, k); float div = 0.125F; for (int subX = 0; subX < 8; subX++) { for (int subZ = 0; subZ < 8; subZ++) { for (int subY = 0; subY < 8; subY++) { if (te.data.get((subX * 8 + subZ) * 8 + subY)) { float minX = subX * div; float maxX = minX + div; float minY = subY * div; float maxY = minY + div; float minZ = subZ * div; float maxZ = minZ + div; func_149676_a(minX, minY, minZ, maxX, maxY, maxZ); super.func_149743_a(world, i, j, k, aabb, list, entity); }  }  }  }  setBlockBoundsBasedOnSelection((IBlockAccess)world, i, j, k); } private boolean isVecInsideYZBounds(AxisAlignedBB bound, Vec3 vec3) { if (vec3 == null) {
/* 476 */       return false;
/*     */     }
/* 478 */     return (vec3.field_72448_b >= bound.field_72338_b && vec3.field_72448_b <= bound.field_72337_e && vec3.field_72449_c >= bound.field_72339_c && vec3.field_72449_c <= bound.field_72334_f); }
/*     */ 
/*     */   
/*     */   private boolean isVecInsideXZBounds(AxisAlignedBB bound, Vec3 vec3) {
/* 482 */     if (vec3 == null) {
/* 483 */       return false;
/*     */     }
/* 485 */     return (vec3.field_72450_a >= bound.field_72340_a && vec3.field_72450_a <= bound.field_72336_d && vec3.field_72449_c >= bound.field_72339_c && vec3.field_72449_c <= bound.field_72334_f);
/*     */   }
/*     */   
/*     */   private boolean isVecInsideXYBounds(AxisAlignedBB bound, Vec3 vec3) {
/* 489 */     if (vec3 == null) {
/* 490 */       return false;
/*     */     }
/* 492 */     return (vec3.field_72450_a >= bound.field_72340_a && vec3.field_72450_a <= bound.field_72336_d && vec3.field_72448_b >= bound.field_72338_b && vec3.field_72448_b <= bound.field_72337_e);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getFlammability(IBlockAccess world, int x, int y, int z, ForgeDirection face) {
/* 498 */     TEDetailed te = (TEDetailed)world.func_147438_o(x, y, z);
/* 499 */     if (te.typeID >= 0)
/* 500 */       return Blocks.field_150480_ab.getFlammability(Block.func_149729_e(te.typeID)); 
/* 501 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getFireSpreadSpeed(IBlockAccess world, int x, int y, int z, ForgeDirection face) {
/* 507 */     TEDetailed te = (TEDetailed)world.func_147438_o(x, y, z);
/* 508 */     if (te.typeID >= 0)
/* 509 */       return Blocks.field_150480_ab.getEncouragement(Block.func_149729_e(te.typeID)); 
/* 510 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Item func_149650_a(int metadata, Random rand, int fortune) {
/* 516 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Blocks\BlockDetailed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
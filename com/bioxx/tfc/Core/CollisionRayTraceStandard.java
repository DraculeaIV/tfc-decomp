/*     */ package com.bioxx.tfc.Core;
/*     */ 
/*     */ import com.bioxx.tfc.api.Interfaces.ICustomCollision;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CollisionRayTraceStandard
/*     */ {
/*     */   public static MovingObjectPosition collisionRayTrace(ICustomCollision b, World world, int x, int y, int z, Vec3 player, Vec3 view) {
/*  19 */     player = player.func_72441_c(-x, -y, -z);
/*  20 */     view = view.func_72441_c(-x, -y, -z);
/*     */     
/*  22 */     List<Object[]> returns = new ArrayList();
/*     */ 
/*     */     
/*  25 */     returns = rayTraceSubBlocks(b, world, player, view, x, y, z, returns);
/*     */     
/*  27 */     if (!returns.isEmpty()) {
/*     */       
/*  29 */       Object[] min = null;
/*  30 */       double distMin = 0.0D;
/*  31 */       for (Object[] ret : returns) {
/*     */         
/*  33 */         double dist = ((Double)ret[2]).doubleValue();
/*  34 */         if (min == null || dist < distMin) {
/*     */           
/*  36 */           distMin = dist;
/*  37 */           min = ret;
/*     */         } 
/*     */       } 
/*  40 */       if (min != null) {
/*     */         
/*  42 */         AxisAlignedBB aabb = (AxisAlignedBB)((Object[])min[3])[0];
/*  43 */         ((Block)b).func_149676_a((float)aabb.field_72340_a, (float)aabb.field_72338_b, (float)aabb.field_72339_c, (float)aabb.field_72336_d, (float)aabb.field_72337_e, (float)aabb.field_72334_f);
/*  44 */         rayTraceBound(aabb, x, y, z, player, view);
/*  45 */         MovingObjectPosition mop = new MovingObjectPosition(x, y, z, ((Byte)min[1]).byteValue(), ((Vec3)min[0]).func_72441_c(x, y, z));
/*  46 */         mop.hitInfo = min[3];
/*  47 */         return mop;
/*     */       } 
/*     */     } 
/*  50 */     ((Block)b).func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
/*     */     
/*  52 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Object[] rayTraceBound(AxisAlignedBB bound, int i, int j, int k, Vec3 player, Vec3 view) {
/*  58 */     Vec3 minX = player.func_72429_b(view, bound.field_72340_a);
/*  59 */     Vec3 maxX = player.func_72429_b(view, bound.field_72336_d);
/*  60 */     Vec3 minY = player.func_72435_c(view, bound.field_72338_b);
/*  61 */     Vec3 maxY = player.func_72435_c(view, bound.field_72337_e);
/*  62 */     Vec3 minZ = player.func_72434_d(view, bound.field_72339_c);
/*  63 */     Vec3 maxZ = player.func_72434_d(view, bound.field_72334_f);
/*  64 */     if (!isVecInsideYZBounds(bound, minX))
/*     */     {
/*  66 */       minX = null;
/*     */     }
/*  68 */     if (!isVecInsideYZBounds(bound, maxX))
/*     */     {
/*  70 */       maxX = null;
/*     */     }
/*  72 */     if (!isVecInsideXZBounds(bound, minY))
/*     */     {
/*  74 */       minY = null;
/*     */     }
/*  76 */     if (!isVecInsideXZBounds(bound, maxY))
/*     */     {
/*  78 */       maxY = null;
/*     */     }
/*  80 */     if (!isVecInsideXYBounds(bound, minZ))
/*     */     {
/*  82 */       minZ = null;
/*     */     }
/*  84 */     if (!isVecInsideXYBounds(bound, maxZ))
/*     */     {
/*  86 */       maxZ = null;
/*     */     }
/*  88 */     Vec3 tracedBound = null;
/*  89 */     if (minX != null && (tracedBound == null || player.func_72438_d(minX) < player.func_72438_d(tracedBound)))
/*     */     {
/*  91 */       tracedBound = minX;
/*     */     }
/*  93 */     if (maxX != null && (tracedBound == null || player.func_72438_d(maxX) < player.func_72438_d(tracedBound)))
/*     */     {
/*  95 */       tracedBound = maxX;
/*     */     }
/*  97 */     if (minY != null && (tracedBound == null || player.func_72438_d(minY) < player.func_72438_d(tracedBound)))
/*     */     {
/*  99 */       tracedBound = minY;
/*     */     }
/* 101 */     if (maxY != null && (tracedBound == null || player.func_72438_d(maxY) < player.func_72438_d(tracedBound)))
/*     */     {
/* 103 */       tracedBound = maxY;
/*     */     }
/* 105 */     if (minZ != null && (tracedBound == null || player.func_72438_d(minZ) < player.func_72438_d(tracedBound)))
/*     */     {
/* 107 */       tracedBound = minZ;
/*     */     }
/* 109 */     if (maxZ != null && (tracedBound == null || player.func_72438_d(maxZ) < player.func_72438_d(tracedBound)))
/*     */     {
/* 111 */       tracedBound = maxZ;
/*     */     }
/* 113 */     if (tracedBound == null) return null; 
/* 114 */     byte side = -1;
/* 115 */     if (tracedBound == minX)
/*     */     {
/* 117 */       side = 4;
/*     */     }
/* 119 */     if (tracedBound == maxX)
/*     */     {
/* 121 */       side = 5;
/*     */     }
/* 123 */     if (tracedBound == minY)
/*     */     {
/* 125 */       side = 0;
/*     */     }
/* 127 */     if (tracedBound == maxY)
/*     */     {
/* 129 */       side = 1;
/*     */     }
/* 131 */     if (tracedBound == minZ)
/*     */     {
/* 133 */       side = 2;
/*     */     }
/* 135 */     if (tracedBound == maxZ)
/*     */     {
/* 137 */       side = 3;
/*     */     }
/* 139 */     return new Object[] { tracedBound, Byte.valueOf(side), Double.valueOf(player.func_72438_d(tracedBound)), bound };
/*     */   }
/*     */ 
/*     */   
/*     */   public static List<Object[]> rayTraceSubBlocks(ICustomCollision b, World world, Vec3 player, Vec3 view, int i, int j, int k, List<Object[]> returns) {
/* 144 */     List<Object[]> bblist = new ArrayList();
/* 145 */     b.addCollisionBoxesToList(world, i, j, k, bblist);
/* 146 */     for (Object[] o : bblist) {
/*     */       
/* 148 */       AxisAlignedBB aabb = (AxisAlignedBB)o[0];
/* 149 */       Object[] ret = rayTraceBound(aabb, i, j, k, player, view);
/*     */       
/* 151 */       if (ret != null)
/*     */       {
/* 153 */         returns.add(new Object[] { ret[0], ret[1], ret[2], o });
/*     */       }
/*     */     } 
/*     */     
/* 157 */     return returns;
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean isVecInsideYZBounds(AxisAlignedBB bound, Vec3 vec3) {
/* 162 */     if (vec3 == null)
/*     */     {
/* 164 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 168 */     return (vec3.field_72448_b >= bound.field_72338_b && vec3.field_72448_b <= bound.field_72337_e && vec3.field_72449_c >= bound.field_72339_c && vec3.field_72449_c <= bound.field_72334_f);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean isVecInsideXZBounds(AxisAlignedBB bound, Vec3 vec3) {
/* 174 */     if (vec3 == null)
/*     */     {
/* 176 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 180 */     return (vec3.field_72450_a >= bound.field_72340_a && vec3.field_72450_a <= bound.field_72336_d && vec3.field_72449_c >= bound.field_72339_c && vec3.field_72449_c <= bound.field_72334_f);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean isVecInsideXYBounds(AxisAlignedBB bound, Vec3 vec3) {
/* 186 */     if (vec3 == null)
/*     */     {
/* 188 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 192 */     return (vec3.field_72450_a >= bound.field_72340_a && vec3.field_72450_a <= bound.field_72336_d && vec3.field_72448_b >= bound.field_72338_b && vec3.field_72448_b <= bound.field_72337_e);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Core\CollisionRayTraceStandard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
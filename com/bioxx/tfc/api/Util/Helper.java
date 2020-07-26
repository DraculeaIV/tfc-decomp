/*     */ package com.bioxx.tfc.api.Util;
/*     */ 
/*     */ import com.bioxx.tfc.TerraFirmaCraft;
/*     */ import com.bioxx.tfc.api.Enums.EnumItemReach;
/*     */ import com.bioxx.tfc.api.Interfaces.ISize;
/*     */ import java.lang.reflect.Field;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Helper
/*     */ {
/*     */   public static MovingObjectPosition getMouseOverObject(EntityLivingBase player, World world) {
/*  20 */     return getMovingObjectPositionFromPlayer(world, player, true);
/*     */   }
/*     */ 
/*     */   
/*     */   public static double getReachDistance(World par1World, EntityLivingBase entity, boolean par3) {
/*  25 */     double var21 = 1.0D;
/*  26 */     if (entity.func_70694_bm() != null && entity.func_70694_bm().func_77973_b() instanceof ISize) {
/*  27 */       var21 *= (((ISize)entity.func_70694_bm().func_77973_b()).getReach(null)).multiplier;
/*     */     }
/*     */     else {
/*     */       
/*  31 */       var21 *= EnumItemReach.SHORT.multiplier;
/*     */     } 
/*  33 */     return var21;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int stringToInt(String s) {
/*  41 */     int result = 0;
/*  42 */     for (char c : s.toCharArray())
/*     */     {
/*  44 */       result += (byte)c;
/*     */     }
/*  46 */     return result;
/*     */   }
/*     */ 
/*     */   
/*     */   public static MovingObjectPosition getMovingObjectPositionFromPlayer(World world, EntityLivingBase entity, boolean scanFluids) {
/*  51 */     return getMovingObjectPositionFromPlayer(world, entity, scanFluids, 4);
/*     */   }
/*     */ 
/*     */   
/*     */   public static MovingObjectPosition getMovingObjectPositionFromPlayer(World world, EntityLivingBase entity, boolean scanFluids, int reach) {
/*  56 */     float var4 = 1.0F;
/*  57 */     float var5 = entity.field_70127_C + (entity.field_70125_A - entity.field_70127_C) * var4;
/*  58 */     float var6 = entity.field_70126_B + (entity.field_70177_z - entity.field_70126_B) * var4;
/*  59 */     double var7 = entity.field_70169_q + (entity.field_70165_t - entity.field_70169_q) * var4;
/*  60 */     double var9 = entity.field_70167_r + (entity.field_70163_u - entity.field_70167_r) * var4 + 1.62D - entity.field_70129_M;
/*  61 */     double var11 = entity.field_70166_s + (entity.field_70161_v - entity.field_70166_s) * var4;
/*  62 */     Vec3 var13 = Vec3.func_72443_a(var7, var9, var11);
/*  63 */     float var14 = MathHelper.func_76134_b(-var6 * 0.017453292F - 3.1415927F);
/*  64 */     float var15 = MathHelper.func_76126_a(-var6 * 0.017453292F - 3.1415927F);
/*  65 */     float var16 = -MathHelper.func_76134_b(-var5 * 0.017453292F);
/*  66 */     float var17 = MathHelper.func_76126_a(-var5 * 0.017453292F);
/*  67 */     float var18 = var15 * var16;
/*  68 */     float var20 = var14 * var16;
/*     */     
/*  70 */     Vec3 var23 = var13.func_72441_c((var18 * reach), (var17 * reach), (var20 * reach));
/*  71 */     return world.func_72901_a(var13, var23, scanFluids);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static float clampFloat(float par0, float par1, float par2) {
/*  80 */     return (par0 < par1) ? par1 : ((par0 > par2) ? par2 : par0);
/*     */   }
/*     */ 
/*     */   
/*     */   public static float roundNumber(float input, float rounding) {
/*  85 */     int o = (int)(input * rounding);
/*  86 */     return o / rounding;
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean usesSRG(Object obj, String srgName) {
/*  91 */     Field[] fields = obj.getClass().getFields();
/*  92 */     for (Field f : fields) {
/*     */       
/*  94 */       if (f.getName().equals(srgName))
/*  95 */         return true; 
/*     */     } 
/*  97 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getInteger(Object obj, String srgName, String obfName, String deobfName, boolean useDeobf) {
/* 102 */     Field f = null;
/*     */     
/*     */     try {
/* 105 */       if (!useDeobf) {
/* 106 */         f = obj.getClass().getDeclaredField(deobfName);
/* 107 */       } else if (usesSRG(obj, srgName)) {
/* 108 */         f = obj.getClass().getDeclaredField(srgName);
/*     */       } else {
/* 110 */         f = obj.getClass().getDeclaredField(obfName);
/* 111 */       }  f.setAccessible(true);
/* 112 */       return ((Integer)f.get(obj)).intValue();
/* 113 */     } catch (NoSuchFieldException e) {
/* 114 */       TerraFirmaCraft.LOG.catching(e);
/* 115 */     } catch (SecurityException e) {
/* 116 */       TerraFirmaCraft.LOG.catching(e);
/* 117 */     } catch (IllegalArgumentException e) {
/* 118 */       TerraFirmaCraft.LOG.catching(e);
/* 119 */     } catch (IllegalAccessException e) {
/* 120 */       TerraFirmaCraft.LOG.catching(e);
/*     */     } 
/* 122 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean getBoolean(Object obj, String srgName, String obfName, String deobfName, boolean useDeobf) {
/* 127 */     Field f = null;
/*     */     
/*     */     try {
/* 130 */       if (!useDeobf) {
/* 131 */         f = obj.getClass().getDeclaredField(deobfName);
/* 132 */       } else if (usesSRG(obj, srgName)) {
/* 133 */         f = obj.getClass().getDeclaredField(srgName);
/*     */       } else {
/* 135 */         f = obj.getClass().getDeclaredField(obfName);
/* 136 */       }  f.setAccessible(true);
/* 137 */       return ((Boolean)f.get(obj)).booleanValue();
/* 138 */     } catch (NoSuchFieldException e) {
/* 139 */       TerraFirmaCraft.LOG.catching(e);
/* 140 */     } catch (SecurityException e) {
/* 141 */       TerraFirmaCraft.LOG.catching(e);
/* 142 */     } catch (IllegalArgumentException e) {
/* 143 */       TerraFirmaCraft.LOG.catching(e);
/* 144 */     } catch (IllegalAccessException e) {
/* 145 */       TerraFirmaCraft.LOG.catching(e);
/*     */     } 
/* 147 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public static Object getObject(Object obj, String srgName, String obfName, String deobfName, boolean useDeobf) {
/* 152 */     Field f = null;
/*     */     
/*     */     try {
/* 155 */       if (!useDeobf) {
/* 156 */         f = obj.getClass().getDeclaredField(deobfName);
/* 157 */       } else if (usesSRG(obj, srgName)) {
/* 158 */         f = obj.getClass().getDeclaredField(srgName);
/*     */       } else {
/* 160 */         f = obj.getClass().getDeclaredField(obfName);
/* 161 */       }  f.setAccessible(true);
/* 162 */       return f.get(obj);
/* 163 */     } catch (NoSuchFieldException e) {
/* 164 */       TerraFirmaCraft.LOG.catching(e);
/* 165 */     } catch (SecurityException e) {
/* 166 */       TerraFirmaCraft.LOG.catching(e);
/* 167 */     } catch (IllegalArgumentException e) {
/* 168 */       TerraFirmaCraft.LOG.catching(e);
/* 169 */     } catch (IllegalAccessException e) {
/* 170 */       TerraFirmaCraft.LOG.catching(e);
/*     */     } 
/* 172 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\api\Util\Helper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
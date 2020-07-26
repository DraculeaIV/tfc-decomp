/*     */ package com.bioxx.tfc.Handlers.Client;
/*     */ 
/*     */ import com.bioxx.tfc.TileEntities.TEStand;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import cpw.mods.fml.common.eventhandler.SubscribeEvent;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.client.event.DrawBlockHighlightEvent;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ArmourStandHighlightHandler
/*     */ {
/*     */   private AxisAlignedBB boxToRender;
/*     */   
/*     */   @SubscribeEvent
/*     */   public void drawBlockHighlightEvent(DrawBlockHighlightEvent evt) {
/*  24 */     World world = evt.player.field_70170_p;
/*  25 */     if (evt.currentItem == null && TFCBlocks.isArmourStand(world.func_147439_a(evt.target.field_72311_b, evt.target.field_72312_c, evt.target.field_72309_d)) && 
/*  26 */       Math.sqrt(evt.target.field_72307_f.func_72445_d(evt.player.field_70165_t, evt.player.field_70163_u, evt.player.field_70161_v)) < 2.5D) {
/*     */ 
/*     */       
/*  29 */       EntityPlayer player = evt.player;
/*  30 */       Vec3 vectorTerm = player.func_70040_Z();
/*  31 */       vectorTerm.field_72450_a *= 0.5D;
/*  32 */       vectorTerm.field_72448_b *= 0.5D;
/*  33 */       vectorTerm.field_72449_c *= 0.5D;
/*  34 */       vectorTerm = vectorTerm.func_72441_c(evt.target.field_72307_f.field_72450_a, evt.target.field_72307_f.field_72448_b, evt.target.field_72307_f.field_72449_c);
/*  35 */       TEStand stand = (TEStand)world.func_147438_o(evt.target.field_72311_b, evt.target.field_72312_c, evt.target.field_72309_d);
/*  36 */       boolean isTop = stand.isTop;
/*     */       
/*  38 */       if (isTop)
/*  39 */         stand = (TEStand)world.func_147438_o(evt.target.field_72311_b, evt.target.field_72312_c - 1, evt.target.field_72309_d); 
/*  40 */       boolean ns = (stand.yaw % 360.0F == 0.0F || stand.yaw % 360.0F == 180.0F);
/*  41 */       double var8 = player.field_70142_S + (player.field_70165_t - player.field_70142_S) * evt.partialTicks;
/*  42 */       double var10 = player.field_70137_T + (player.field_70163_u - player.field_70137_T) * evt.partialTicks;
/*  43 */       double var12 = player.field_70136_U + (player.field_70161_v - player.field_70136_U) * evt.partialTicks;
/*     */ 
/*     */       
/*  46 */       AxisAlignedBB head = AxisAlignedBB.func_72330_a(evt.target.field_72311_b + 0.5D - 0.3D, evt.target.field_72312_c + 1.35D + (isTop ? -1 : false), evt.target.field_72309_d + 0.5D - 0.3D, evt.target.field_72311_b + 0.5D + 0.3D, evt.target.field_72312_c + 1.95D + (isTop ? -1 : false), evt.target.field_72309_d + 0.5D + 0.3D);
/*     */ 
/*     */ 
/*     */       
/*  50 */       AxisAlignedBB body = AxisAlignedBB.func_72330_a(evt.target.field_72311_b + 0.5D - 0.55D, evt.target.field_72312_c + 0.75D + (isTop ? -1 : false), evt.target.field_72309_d + 0.5D - 0.17D, evt.target.field_72311_b + 0.5D + 0.55D, evt.target.field_72312_c + 1.5D + (isTop ? -1 : false), evt.target.field_72309_d + 0.5D + 0.17D);
/*     */ 
/*     */       
/*  53 */       if (!ns) {
/*  54 */         body = AxisAlignedBB.func_72330_a(evt.target.field_72311_b + 0.5D - 0.17D, evt.target.field_72312_c + 0.75D + (isTop ? -1 : false), evt.target.field_72309_d + 0.5D - 0.55D, evt.target.field_72311_b + 0.5D + 0.17D, evt.target.field_72312_c + 1.5D + (isTop ? -1 : false), evt.target.field_72309_d + 0.5D + 0.55D);
/*     */       }
/*     */ 
/*     */       
/*  58 */       AxisAlignedBB legs = AxisAlignedBB.func_72330_a(evt.target.field_72311_b + 0.5D - 0.315D, evt.target.field_72312_c + 0.19999999999999996D + (isTop ? -1 : false), evt.target.field_72309_d + 0.5D - 0.1395D, evt.target.field_72311_b + 0.5D + 0.315D, evt.target.field_72312_c + 0.9D + (isTop ? -1 : false), evt.target.field_72309_d + 0.5D + 0.1395D);
/*     */ 
/*     */       
/*  61 */       if (!ns) {
/*  62 */         legs = AxisAlignedBB.func_72330_a(evt.target.field_72311_b + 0.5D - 0.1395D, evt.target.field_72312_c + 0.19999999999999996D + (isTop ? -1 : false), evt.target.field_72309_d + 0.5D - 0.315D, evt.target.field_72311_b + 0.5D + 0.1395D, evt.target.field_72312_c + 0.9D + (isTop ? -1 : false), evt.target.field_72309_d + 0.5D + 0.315D);
/*     */       }
/*     */ 
/*     */       
/*  66 */       AxisAlignedBB feet = AxisAlignedBB.func_72330_a(evt.target.field_72311_b + 0.5D - 0.35D, evt.target.field_72312_c + 0.15D + (isTop ? -1 : false), evt.target.field_72309_d + 0.5D - 0.17D, evt.target.field_72311_b + 0.5D + 0.35D, evt.target.field_72312_c + 0.40000000000000013D + (isTop ? -1 : false), evt.target.field_72309_d + 0.5D + 0.17D);
/*     */ 
/*     */       
/*  69 */       if (!ns) {
/*  70 */         feet = AxisAlignedBB.func_72330_a(evt.target.field_72311_b + 0.5D - 0.17D, evt.target.field_72312_c + 0.15D + (isTop ? -1 : false), evt.target.field_72309_d + 0.5D - 0.35D, evt.target.field_72311_b + 0.5D + 0.17D, evt.target.field_72312_c + 0.40000000000000013D + (isTop ? -1 : false), evt.target.field_72309_d + 0.5D + 0.35D);
/*     */       }
/*     */ 
/*     */       
/*  74 */       Vec3 unit = vectorTerm.func_72432_b();
/*  75 */       unit = player.func_70040_Z();
/*  76 */       if (isVecInsideBox(head, player, unit, var8, var10, var12) && stand.items[4] != null) {
/*     */         
/*  78 */         this.boxToRender = head;
/*     */       
/*     */       }
/*  81 */       else if (isVecInsideBox(body, player, unit, var8, var10, var12) && stand.items[3] != null) {
/*     */         
/*  83 */         this.boxToRender = body;
/*     */       
/*     */       }
/*  86 */       else if (isVecInsideBox(legs, player, unit, var8, var10, var12) && stand.items[2] != null) {
/*     */         
/*  88 */         this.boxToRender = legs;
/*     */       
/*     */       }
/*  91 */       else if (isVecInsideBox(feet, player, unit, var8, var10, var12) && stand.items[1] != null) {
/*     */         
/*  93 */         this.boxToRender = feet;
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 101 */       if (this.boxToRender != null) {
/*     */ 
/*     */         
/* 104 */         GL11.glEnable(3042);
/* 105 */         GL11.glBlendFunc(1, 1);
/* 106 */         GL11.glDisable(3553);
/* 107 */         GL11.glDepthMask(false);
/*     */ 
/*     */         
/* 110 */         GL11.glBlendFunc(770, 771);
/* 111 */         GL11.glColor4f(1.0F, 0.0F, 0.0F, 0.4F);
/* 112 */         GL11.glLineWidth(4.0F);
/* 113 */         GL11.glDepthMask(true);
/*     */         
/* 115 */         drawOutlinedBoundingBox(this.boxToRender.func_72314_b(0.019999999552965164D, 0.019999999552965164D, 0.019999999552965164D).func_72325_c(-var8, -var10, -var12));
/* 116 */         GL11.glDepthMask(true);
/* 117 */         GL11.glEnable(3553);
/* 118 */         GL11.glDisable(3042);
/*     */       } 
/* 120 */       this.boxToRender = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isVecInsideBox(AxisAlignedBB aabb, EntityPlayer player, Vec3 unit, double xOffset, double yOffset, double zOffset) {
/* 126 */     unit = player.func_70040_Z();
/* 127 */     aabb.field_72338_b += 0.1D;
/* 128 */     aabb.field_72337_e += 0.1D;
/* 129 */     Vec3 playerVec = Vec3.func_72443_a(player.field_70165_t, player.field_70163_u + player.eyeHeight, player.field_70161_v);
/*     */ 
/*     */     
/* 132 */     Vec3 distBlockxyz = playerVec.func_72444_a(Vec3.func_72443_a(aabb.field_72340_a, aabb.field_72338_b, aabb.field_72339_c)).func_72432_b();
/* 133 */     Vec3 distBlockXYZ = playerVec.func_72444_a(Vec3.func_72443_a(aabb.field_72336_d, aabb.field_72337_e, aabb.field_72334_f)).func_72432_b();
/*     */     
/* 135 */     Vec3 distBlockxyZ = playerVec.func_72444_a(Vec3.func_72443_a(aabb.field_72340_a, aabb.field_72338_b, aabb.field_72334_f)).func_72432_b();
/* 136 */     Vec3 distBlockXYz = playerVec.func_72444_a(Vec3.func_72443_a(aabb.field_72336_d, aabb.field_72337_e, aabb.field_72339_c)).func_72432_b();
/*     */     
/* 138 */     Vec3 distBlockxYZ = playerVec.func_72444_a(Vec3.func_72443_a(aabb.field_72340_a, aabb.field_72337_e, aabb.field_72334_f)).func_72432_b();
/* 139 */     Vec3 distBlockXyz = playerVec.func_72444_a(Vec3.func_72443_a(aabb.field_72336_d, aabb.field_72338_b, aabb.field_72339_c)).func_72432_b();
/*     */     
/* 141 */     Vec3 distBlockxYz = playerVec.func_72444_a(Vec3.func_72443_a(aabb.field_72340_a, aabb.field_72337_e, aabb.field_72339_c)).func_72432_b();
/* 142 */     Vec3 distBlockXyZ = playerVec.func_72444_a(Vec3.func_72443_a(aabb.field_72336_d, aabb.field_72338_b, aabb.field_72334_f)).func_72432_b();
/*     */     
/* 144 */     double currentLongestProj = 0.0D;
/* 145 */     currentLongestProj = Math.max(currentLongestProj, unit.func_72430_b(distBlockxyz));
/* 146 */     currentLongestProj = Math.max(currentLongestProj, unit.func_72430_b(distBlockXYZ));
/* 147 */     currentLongestProj = Math.max(currentLongestProj, unit.func_72430_b(distBlockXyz));
/* 148 */     currentLongestProj = Math.max(currentLongestProj, unit.func_72430_b(distBlockxYZ));
/* 149 */     currentLongestProj = Math.max(currentLongestProj, unit.func_72430_b(distBlockxYz));
/* 150 */     currentLongestProj = Math.max(currentLongestProj, unit.func_72430_b(distBlockXyZ));
/* 151 */     currentLongestProj = Math.max(currentLongestProj, unit.func_72430_b(distBlockxyZ));
/* 152 */     currentLongestProj = Math.max(currentLongestProj, unit.func_72430_b(distBlockXYz));
/*     */     
/* 154 */     unit.field_72450_a *= currentLongestProj * 0.99D; unit.field_72448_b *= currentLongestProj * 0.99D; unit.field_72449_c *= currentLongestProj * 0.99D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 164 */     boolean insideBoxX = ((unit.field_72450_a >= distBlockxyz.field_72450_a && unit.field_72450_a <= distBlockXYZ.field_72450_a) || (unit.field_72450_a >= distBlockxyZ.field_72450_a && unit.field_72450_a <= distBlockXYz.field_72450_a) || (unit.field_72450_a >= distBlockxYZ.field_72450_a && unit.field_72450_a <= distBlockXyz.field_72450_a) || (unit.field_72450_a >= distBlockxYz.field_72450_a && unit.field_72450_a <= distBlockXyZ.field_72450_a));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 169 */     boolean insideBoxY = ((unit.field_72448_b >= distBlockxyz.field_72448_b && unit.field_72448_b <= distBlockXYZ.field_72448_b) || (unit.field_72448_b >= distBlockxyZ.field_72448_b && unit.field_72448_b <= distBlockXYz.field_72448_b) || (unit.field_72448_b >= distBlockXyz.field_72448_b && unit.field_72448_b <= distBlockxYZ.field_72448_b) || (unit.field_72448_b >= distBlockXyZ.field_72448_b && unit.field_72448_b <= distBlockxYz.field_72448_b));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 174 */     boolean insideBoxZ = ((unit.field_72449_c >= distBlockxyz.field_72449_c && unit.field_72449_c <= distBlockXYZ.field_72449_c) || (unit.field_72449_c >= distBlockXYz.field_72449_c && unit.field_72449_c <= distBlockxyZ.field_72449_c) || (unit.field_72449_c >= distBlockXyz.field_72449_c && unit.field_72449_c <= distBlockxYZ.field_72449_c) || (unit.field_72449_c >= distBlockxYz.field_72449_c && unit.field_72449_c <= distBlockXyZ.field_72449_c));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 208 */     aabb.field_72338_b -= 0.1D;
/* 209 */     aabb.field_72337_e -= 0.1D;
/* 210 */     return (insideBoxX && insideBoxY && insideBoxZ);
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawLine(Vec3 origin, Vec3 vector) {
/* 215 */     Tessellator var2 = Tessellator.field_78398_a;
/* 216 */     var2.func_78371_b(3);
/*     */ 
/*     */     
/* 219 */     var2.func_78377_a(origin.field_72450_a, origin.field_72448_b, origin.field_72449_c);
/* 220 */     var2.func_78377_a(vector.field_72450_a, vector.field_72448_b, vector.field_72449_c);
/* 221 */     var2.func_78381_a();
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawOutlinedBoundingBox(AxisAlignedBB par1AxisAlignedBB) {
/* 226 */     Tessellator var2 = Tessellator.field_78398_a;
/* 227 */     var2.func_78371_b(3);
/* 228 */     var2.func_78377_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72338_b, par1AxisAlignedBB.field_72339_c);
/* 229 */     var2.func_78377_a(par1AxisAlignedBB.field_72336_d, par1AxisAlignedBB.field_72338_b, par1AxisAlignedBB.field_72339_c);
/* 230 */     var2.func_78377_a(par1AxisAlignedBB.field_72336_d, par1AxisAlignedBB.field_72338_b, par1AxisAlignedBB.field_72334_f);
/* 231 */     var2.func_78377_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72338_b, par1AxisAlignedBB.field_72334_f);
/* 232 */     var2.func_78377_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72338_b, par1AxisAlignedBB.field_72339_c);
/* 233 */     var2.func_78381_a();
/* 234 */     var2.func_78371_b(3);
/* 235 */     var2.func_78377_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72339_c);
/* 236 */     var2.func_78377_a(par1AxisAlignedBB.field_72336_d, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72339_c);
/* 237 */     var2.func_78377_a(par1AxisAlignedBB.field_72336_d, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72334_f);
/* 238 */     var2.func_78377_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72334_f);
/* 239 */     var2.func_78377_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72339_c);
/* 240 */     var2.func_78381_a();
/* 241 */     var2.func_78371_b(1);
/* 242 */     var2.func_78377_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72338_b, par1AxisAlignedBB.field_72339_c);
/* 243 */     var2.func_78377_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72339_c);
/* 244 */     var2.func_78377_a(par1AxisAlignedBB.field_72336_d, par1AxisAlignedBB.field_72338_b, par1AxisAlignedBB.field_72339_c);
/* 245 */     var2.func_78377_a(par1AxisAlignedBB.field_72336_d, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72339_c);
/* 246 */     var2.func_78377_a(par1AxisAlignedBB.field_72336_d, par1AxisAlignedBB.field_72338_b, par1AxisAlignedBB.field_72334_f);
/* 247 */     var2.func_78377_a(par1AxisAlignedBB.field_72336_d, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72334_f);
/* 248 */     var2.func_78377_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72338_b, par1AxisAlignedBB.field_72334_f);
/* 249 */     var2.func_78377_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72334_f);
/* 250 */     var2.func_78381_a();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Handlers\Client\ArmourStandHighlightHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
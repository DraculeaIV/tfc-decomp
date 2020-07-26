/*     */ package com.bioxx.tfc.Handlers.Client;
/*     */ 
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import cpw.mods.fml.common.eventhandler.SubscribeEvent;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.client.event.DrawBlockHighlightEvent;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PlankHighlightHandler
/*     */ {
/*     */   @SubscribeEvent
/*     */   public void drawBlockHighlightEvent(DrawBlockHighlightEvent evt) {
/*  21 */     World world = evt.player.field_70170_p;
/*  22 */     double var8 = evt.player.field_70142_S + (evt.player.field_70165_t - evt.player.field_70142_S) * evt.partialTicks;
/*  23 */     double var10 = evt.player.field_70137_T + (evt.player.field_70163_u - evt.player.field_70137_T) * evt.partialTicks;
/*  24 */     double var12 = evt.player.field_70136_U + (evt.player.field_70161_v - evt.player.field_70136_U) * evt.partialTicks;
/*     */     
/*  26 */     if (evt.currentItem != null && evt.currentItem.func_77973_b() instanceof com.bioxx.tfc.Items.ItemPlank) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  52 */       GL11.glDisable(3553);
/*     */       
/*  54 */       boolean isConstruct = (world.func_147439_a(evt.target.field_72311_b, evt.target.field_72312_c, evt.target.field_72309_d) == TFCBlocks.woodConstruct);
/*     */ 
/*     */       
/*  57 */       double hitX = Math.round((evt.target.field_72307_f.field_72450_a - evt.target.field_72311_b) * 100.0D) / 100.0D;
/*  58 */       double hitY = Math.round((evt.target.field_72307_f.field_72448_b - evt.target.field_72312_c) * 100.0D) / 100.0D;
/*  59 */       double hitZ = Math.round((evt.target.field_72307_f.field_72449_c - evt.target.field_72309_d) * 100.0D) / 100.0D;
/*     */ 
/*     */       
/*  62 */       double subX = (int)(hitX * 8.0D) / 8.0D;
/*  63 */       double subY = (int)(hitY * 8.0D) / 8.0D;
/*  64 */       double subZ = (int)(hitZ * 8.0D) / 8.0D;
/*     */ 
/*     */       
/*  67 */       double minX = evt.target.field_72311_b + subX;
/*  68 */       double minY = evt.target.field_72312_c + subY;
/*  69 */       double minZ = evt.target.field_72309_d + subZ;
/*  70 */       double maxX = minX + 0.125D;
/*  71 */       double maxY = minY + 0.125D;
/*  72 */       double maxZ = minZ + 0.125D;
/*     */       
/*  74 */       if (isConstruct && hitY != 0.0D && hitY != 1.0D && hitZ != 0.0D && hitZ != 1.0D && hitX != 0.0D && hitX != 1.0D) {
/*     */         
/*  76 */         if (evt.target.field_72310_e == 0)
/*     */         {
/*  78 */           minY = evt.target.field_72312_c;
/*  79 */           maxY = (evt.target.field_72312_c + 1);
/*     */         }
/*  81 */         else if (evt.target.field_72310_e == 1)
/*     */         {
/*  83 */           minY = evt.target.field_72312_c;
/*  84 */           maxY = (evt.target.field_72312_c + 1);
/*     */         }
/*  86 */         else if (evt.target.field_72310_e == 2)
/*     */         {
/*  88 */           minZ = evt.target.field_72309_d;
/*  89 */           maxZ = (evt.target.field_72309_d + 1);
/*     */         }
/*  91 */         else if (evt.target.field_72310_e == 3)
/*     */         {
/*  93 */           minZ = evt.target.field_72309_d;
/*  94 */           maxZ = (evt.target.field_72309_d + 1);
/*     */         }
/*  96 */         else if (evt.target.field_72310_e == 4)
/*     */         {
/*  98 */           minX = evt.target.field_72311_b;
/*  99 */           maxX = (evt.target.field_72311_b + 1);
/*     */         }
/* 101 */         else if (evt.target.field_72310_e == 5)
/*     */         {
/* 103 */           minX = evt.target.field_72311_b;
/* 104 */           maxX = (evt.target.field_72311_b + 1);
/*     */         
/*     */         }
/*     */       
/*     */       }
/* 109 */       else if (evt.target.field_72310_e == 0) {
/*     */         
/* 111 */         maxY = minY;
/* 112 */         minY--;
/*     */       }
/* 114 */       else if (evt.target.field_72310_e == 1) {
/*     */         
/* 116 */         maxY = minY + 1.0D;
/*     */       }
/* 118 */       else if (evt.target.field_72310_e == 2) {
/*     */         
/* 120 */         maxZ = minZ;
/* 121 */         minZ--;
/*     */       }
/* 123 */       else if (evt.target.field_72310_e == 3) {
/*     */         
/* 125 */         maxZ = minZ + 1.0D;
/*     */       }
/* 127 */       else if (evt.target.field_72310_e == 4) {
/*     */         
/* 129 */         maxX = minX;
/* 130 */         minX--;
/*     */       }
/* 132 */       else if (evt.target.field_72310_e == 5) {
/*     */         
/* 134 */         maxX = minX + 1.0D;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 139 */       GL11.glEnable(3042);
/*     */       
/* 141 */       GL11.glBlendFunc(770, 771);
/* 142 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.4F);
/* 143 */       GL11.glDisable(2884);
/* 144 */       GL11.glDepthMask(false);
/*     */       
/* 146 */       drawBox(AxisAlignedBB.func_72330_a(minX, minY, minZ, maxX, maxY, maxZ).func_72314_b(0.0020000000949949026D, 0.0020000000949949026D, 0.0020000000949949026D).func_72325_c(-var8, -var10, -var12));
/*     */       
/* 148 */       GL11.glDepthMask(true);
/* 149 */       GL11.glEnable(3553);
/* 150 */       GL11.glDisable(3042);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawFaceUV(AxisAlignedBB par1AxisAlignedBB, int side) {
/* 156 */     Tessellator var2 = Tessellator.field_78398_a;
/*     */     
/* 158 */     var2.func_78369_a(1.0F, 1.0F, 1.0F, 1.0F);
/*     */     
/* 160 */     var2.func_78371_b(7);
/*     */     
/* 162 */     if (side == 0) {
/*     */       
/* 164 */       var2.func_78374_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72338_b, par1AxisAlignedBB.field_72339_c, 0.0D, 0.0D);
/* 165 */       var2.func_78374_a(par1AxisAlignedBB.field_72336_d, par1AxisAlignedBB.field_72338_b, par1AxisAlignedBB.field_72339_c, 1.0D, 0.0D);
/* 166 */       var2.func_78374_a(par1AxisAlignedBB.field_72336_d, par1AxisAlignedBB.field_72338_b, par1AxisAlignedBB.field_72334_f, 1.0D, 1.0D);
/* 167 */       var2.func_78374_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72338_b, par1AxisAlignedBB.field_72334_f, 0.0D, 1.0D);
/*     */     }
/* 169 */     else if (side == 1) {
/*     */       
/* 171 */       var2.func_78374_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72339_c, 0.0D, 0.0D);
/* 172 */       var2.func_78374_a(par1AxisAlignedBB.field_72336_d, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72339_c, 1.0D, 0.0D);
/* 173 */       var2.func_78374_a(par1AxisAlignedBB.field_72336_d, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72334_f, 1.0D, 1.0D);
/* 174 */       var2.func_78374_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72334_f, 0.0D, 1.0D);
/*     */     }
/* 176 */     else if (side == 2) {
/*     */       
/* 178 */       var2.func_78374_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72338_b, par1AxisAlignedBB.field_72339_c, 0.0D, 0.0D);
/* 179 */       var2.func_78374_a(par1AxisAlignedBB.field_72336_d, par1AxisAlignedBB.field_72338_b, par1AxisAlignedBB.field_72339_c, 1.0D, 0.0D);
/* 180 */       var2.func_78374_a(par1AxisAlignedBB.field_72336_d, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72339_c, 1.0D, 1.0D);
/* 181 */       var2.func_78374_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72339_c, 0.0D, 1.0D);
/*     */     }
/* 183 */     else if (side == 3) {
/*     */       
/* 185 */       var2.func_78374_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72338_b, par1AxisAlignedBB.field_72334_f, 0.0D, 0.0D);
/* 186 */       var2.func_78374_a(par1AxisAlignedBB.field_72336_d, par1AxisAlignedBB.field_72338_b, par1AxisAlignedBB.field_72334_f, 1.0D, 0.0D);
/* 187 */       var2.func_78374_a(par1AxisAlignedBB.field_72336_d, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72334_f, 1.0D, 1.0D);
/* 188 */       var2.func_78374_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72334_f, 0.0D, 1.0D);
/*     */     }
/* 190 */     else if (side == 4) {
/*     */       
/* 192 */       var2.func_78374_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72338_b, par1AxisAlignedBB.field_72339_c, 0.0D, 0.0D);
/* 193 */       var2.func_78374_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72338_b, par1AxisAlignedBB.field_72334_f, 1.0D, 0.0D);
/* 194 */       var2.func_78374_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72334_f, 1.0D, 1.0D);
/* 195 */       var2.func_78374_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72339_c, 0.0D, 1.0D);
/*     */     }
/* 197 */     else if (side == 5) {
/*     */       
/* 199 */       var2.func_78374_a(par1AxisAlignedBB.field_72336_d, par1AxisAlignedBB.field_72338_b, par1AxisAlignedBB.field_72339_c, 0.0D, 0.0D);
/* 200 */       var2.func_78374_a(par1AxisAlignedBB.field_72336_d, par1AxisAlignedBB.field_72338_b, par1AxisAlignedBB.field_72334_f, 1.0D, 0.0D);
/* 201 */       var2.func_78374_a(par1AxisAlignedBB.field_72336_d, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72334_f, 1.0D, 1.0D);
/* 202 */       var2.func_78374_a(par1AxisAlignedBB.field_72336_d, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72339_c, 0.0D, 1.0D);
/*     */     } 
/* 204 */     var2.func_78381_a();
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawFace(AxisAlignedBB par1AxisAlignedBB) {
/* 209 */     Tessellator var2 = Tessellator.field_78398_a;
/*     */ 
/*     */     
/* 212 */     var2.func_78371_b(7);
/* 213 */     var2.func_78377_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72339_c);
/* 214 */     var2.func_78377_a(par1AxisAlignedBB.field_72336_d, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72339_c);
/* 215 */     var2.func_78377_a(par1AxisAlignedBB.field_72336_d, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72334_f);
/* 216 */     var2.func_78377_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72334_f);
/* 217 */     var2.func_78381_a();
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawBox(AxisAlignedBB par1AxisAlignedBB) {
/* 222 */     Tessellator var2 = Tessellator.field_78398_a;
/*     */ 
/*     */     
/* 225 */     var2.func_78371_b(7);
/* 226 */     var2.func_78377_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72339_c);
/* 227 */     var2.func_78377_a(par1AxisAlignedBB.field_72336_d, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72339_c);
/* 228 */     var2.func_78377_a(par1AxisAlignedBB.field_72336_d, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72334_f);
/* 229 */     var2.func_78377_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72334_f);
/* 230 */     var2.func_78381_a();
/*     */ 
/*     */     
/* 233 */     var2.func_78371_b(7);
/* 234 */     var2.func_78377_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72338_b, par1AxisAlignedBB.field_72339_c);
/* 235 */     var2.func_78377_a(par1AxisAlignedBB.field_72336_d, par1AxisAlignedBB.field_72338_b, par1AxisAlignedBB.field_72339_c);
/* 236 */     var2.func_78377_a(par1AxisAlignedBB.field_72336_d, par1AxisAlignedBB.field_72338_b, par1AxisAlignedBB.field_72334_f);
/* 237 */     var2.func_78377_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72338_b, par1AxisAlignedBB.field_72334_f);
/* 238 */     var2.func_78381_a();
/*     */ 
/*     */     
/* 241 */     var2.func_78371_b(7);
/* 242 */     var2.func_78377_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72338_b, par1AxisAlignedBB.field_72339_c);
/* 243 */     var2.func_78377_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72339_c);
/* 244 */     var2.func_78377_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72334_f);
/* 245 */     var2.func_78377_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72338_b, par1AxisAlignedBB.field_72334_f);
/* 246 */     var2.func_78381_a();
/*     */ 
/*     */     
/* 249 */     var2.func_78371_b(7);
/* 250 */     var2.func_78377_a(par1AxisAlignedBB.field_72336_d, par1AxisAlignedBB.field_72338_b, par1AxisAlignedBB.field_72334_f);
/* 251 */     var2.func_78377_a(par1AxisAlignedBB.field_72336_d, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72334_f);
/* 252 */     var2.func_78377_a(par1AxisAlignedBB.field_72336_d, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72339_c);
/* 253 */     var2.func_78377_a(par1AxisAlignedBB.field_72336_d, par1AxisAlignedBB.field_72338_b, par1AxisAlignedBB.field_72339_c);
/* 254 */     var2.func_78381_a();
/*     */ 
/*     */     
/* 257 */     var2.func_78371_b(7);
/* 258 */     var2.func_78377_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72338_b, par1AxisAlignedBB.field_72339_c);
/* 259 */     var2.func_78377_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72339_c);
/* 260 */     var2.func_78377_a(par1AxisAlignedBB.field_72336_d, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72339_c);
/* 261 */     var2.func_78377_a(par1AxisAlignedBB.field_72336_d, par1AxisAlignedBB.field_72338_b, par1AxisAlignedBB.field_72339_c);
/* 262 */     var2.func_78381_a();
/*     */ 
/*     */     
/* 265 */     var2.func_78371_b(7);
/* 266 */     var2.func_78377_a(par1AxisAlignedBB.field_72336_d, par1AxisAlignedBB.field_72338_b, par1AxisAlignedBB.field_72334_f);
/* 267 */     var2.func_78377_a(par1AxisAlignedBB.field_72336_d, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72334_f);
/* 268 */     var2.func_78377_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72334_f);
/* 269 */     var2.func_78377_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72338_b, par1AxisAlignedBB.field_72334_f);
/* 270 */     var2.func_78381_a();
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawOutlinedBoundingBox(AxisAlignedBB par1AxisAlignedBB) {
/* 275 */     Tessellator var2 = Tessellator.field_78398_a;
/* 276 */     var2.func_78371_b(3);
/* 277 */     var2.func_78377_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72338_b, par1AxisAlignedBB.field_72339_c);
/* 278 */     var2.func_78377_a(par1AxisAlignedBB.field_72336_d, par1AxisAlignedBB.field_72338_b, par1AxisAlignedBB.field_72339_c);
/* 279 */     var2.func_78377_a(par1AxisAlignedBB.field_72336_d, par1AxisAlignedBB.field_72338_b, par1AxisAlignedBB.field_72334_f);
/* 280 */     var2.func_78377_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72338_b, par1AxisAlignedBB.field_72334_f);
/* 281 */     var2.func_78377_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72338_b, par1AxisAlignedBB.field_72339_c);
/* 282 */     var2.func_78381_a();
/* 283 */     var2.func_78371_b(3);
/* 284 */     var2.func_78377_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72339_c);
/* 285 */     var2.func_78377_a(par1AxisAlignedBB.field_72336_d, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72339_c);
/* 286 */     var2.func_78377_a(par1AxisAlignedBB.field_72336_d, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72334_f);
/* 287 */     var2.func_78377_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72334_f);
/* 288 */     var2.func_78377_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72339_c);
/* 289 */     var2.func_78381_a();
/* 290 */     var2.func_78371_b(1);
/* 291 */     var2.func_78377_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72338_b, par1AxisAlignedBB.field_72339_c);
/* 292 */     var2.func_78377_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72339_c);
/* 293 */     var2.func_78377_a(par1AxisAlignedBB.field_72336_d, par1AxisAlignedBB.field_72338_b, par1AxisAlignedBB.field_72339_c);
/* 294 */     var2.func_78377_a(par1AxisAlignedBB.field_72336_d, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72339_c);
/* 295 */     var2.func_78377_a(par1AxisAlignedBB.field_72336_d, par1AxisAlignedBB.field_72338_b, par1AxisAlignedBB.field_72334_f);
/* 296 */     var2.func_78377_a(par1AxisAlignedBB.field_72336_d, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72334_f);
/* 297 */     var2.func_78377_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72338_b, par1AxisAlignedBB.field_72334_f);
/* 298 */     var2.func_78377_a(par1AxisAlignedBB.field_72340_a, par1AxisAlignedBB.field_72337_e, par1AxisAlignedBB.field_72334_f);
/* 299 */     var2.func_78381_a();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Handlers\Client\PlankHighlightHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
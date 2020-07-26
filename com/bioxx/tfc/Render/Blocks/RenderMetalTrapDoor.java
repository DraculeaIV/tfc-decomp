/*     */ package com.bioxx.tfc.Render.Blocks;
/*     */ 
/*     */ import com.bioxx.tfc.Blocks.BlockMetalSheet;
/*     */ import com.bioxx.tfc.Blocks.BlockMetalTrapDoor;
/*     */ import com.bioxx.tfc.TileEntities.TEMetalTrapDoor;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.client.renderer.RenderBlocks;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RenderMetalTrapDoor
/*     */   implements ISimpleBlockRenderingHandler
/*     */ {
/*     */   public static boolean render(Block block, int i, int j, int k, RenderBlocks renderer) {
/*  20 */     IBlockAccess access = renderer.field_147845_a;
/*  21 */     TEMetalTrapDoor te = (TEMetalTrapDoor)access.func_147438_o(i, j, k);
/*  22 */     int side = te.data & 0x7;
/*  23 */     int hinge = te.data >> 4;
/*  24 */     float f = 0.0625F;
/*     */ 
/*     */ 
/*     */     
/*  28 */     float fx = 0.0F;
/*  29 */     float fy = 0.0F;
/*  30 */     float fz = 0.0F;
/*  31 */     float fx2 = 1.0F;
/*  32 */     float fy2 = 1.0F;
/*  33 */     float fz2 = 1.0F;
/*  34 */     renderer.field_147837_f = true;
/*  35 */     if (BlockMetalTrapDoor.isTrapdoorOpen(access.func_72805_g(i, j, k))) {
/*     */       
/*  37 */       if (hinge == 0) {
/*     */         
/*  39 */         switch (side) {
/*     */ 
/*     */           
/*     */           case 0:
/*  43 */             fx2 = f;
/*  44 */             fy2 = 1.0F - f;
/*     */             break;
/*     */ 
/*     */           
/*     */           case 1:
/*  49 */             fy = f;
/*  50 */             fx2 = f;
/*     */             break;
/*     */ 
/*     */           
/*     */           case 2:
/*  55 */             fx2 = f;
/*  56 */             fz2 = 1.0F - f;
/*     */             break;
/*     */ 
/*     */           
/*     */           case 3:
/*  61 */             fz = f;
/*  62 */             fx2 = f;
/*     */             break;
/*     */ 
/*     */           
/*     */           case 4:
/*  67 */             fy2 = f;
/*  68 */             fx2 = 1.0F - f;
/*     */             break;
/*     */ 
/*     */           
/*     */           case 5:
/*  73 */             fy2 = f;
/*  74 */             fx = f;
/*     */             break;
/*     */           
/*     */           default:
/*  78 */             fx2 = f;
/*     */             break;
/*     */         } 
/*     */       
/*  82 */       } else if (hinge == 1) {
/*     */         
/*  84 */         switch (side) {
/*     */ 
/*     */           
/*     */           case 0:
/*  88 */             fz2 = f;
/*  89 */             fy2 = 1.0F - f;
/*     */             break;
/*     */ 
/*     */           
/*     */           case 1:
/*  94 */             fy = f;
/*  95 */             fz2 = f;
/*     */             break;
/*     */ 
/*     */           
/*     */           case 2:
/* 100 */             fy2 = f;
/* 101 */             fz2 = 1.0F - f;
/*     */             break;
/*     */ 
/*     */           
/*     */           case 3:
/* 106 */             fy2 = f;
/* 107 */             fz = f;
/*     */             break;
/*     */ 
/*     */           
/*     */           case 4:
/* 112 */             fx2 = 1.0F - f;
/* 113 */             fz2 = f;
/*     */             break;
/*     */ 
/*     */           
/*     */           case 5:
/* 118 */             fx = f;
/* 119 */             fz2 = f;
/*     */             break;
/*     */           
/*     */           default:
/* 123 */             fz2 = f;
/*     */             break;
/*     */         } 
/*     */       
/* 127 */       } else if (hinge == 2) {
/*     */         
/* 129 */         switch (side) {
/*     */ 
/*     */           
/*     */           case 0:
/* 133 */             fx = 1.0F - f;
/* 134 */             fy2 = 1.0F - f;
/*     */             break;
/*     */ 
/*     */           
/*     */           case 1:
/* 139 */             fx = 1.0F - f;
/* 140 */             fy = f;
/*     */             break;
/*     */ 
/*     */           
/*     */           case 2:
/* 145 */             fx = 1.0F - f;
/* 146 */             fz2 = 1.0F - f;
/*     */             break;
/*     */ 
/*     */           
/*     */           case 3:
/* 151 */             fx = 1.0F - f;
/* 152 */             fz = f;
/*     */             break;
/*     */ 
/*     */           
/*     */           case 4:
/* 157 */             fx2 = 1.0F - f;
/* 158 */             fy = 1.0F - f;
/*     */             break;
/*     */ 
/*     */           
/*     */           case 5:
/* 163 */             fy = 1.0F - f;
/* 164 */             fx = f;
/*     */             break;
/*     */           
/*     */           default:
/* 168 */             fx = 1.0F - f;
/*     */             break;
/*     */         } 
/*     */ 
/*     */       
/* 173 */       } else if (hinge == 3) {
/*     */         
/* 175 */         switch (side) {
/*     */ 
/*     */           
/*     */           case 0:
/* 179 */             fy2 = 1.0F - f;
/* 180 */             fz = 1.0F - f;
/*     */             break;
/*     */ 
/*     */           
/*     */           case 1:
/* 185 */             fy = f;
/* 186 */             fz = 1.0F - f;
/*     */             break;
/*     */ 
/*     */           
/*     */           case 2:
/* 191 */             fy = 1.0F - f;
/* 192 */             fz2 = 1.0F - f;
/*     */             break;
/*     */ 
/*     */           
/*     */           case 3:
/* 197 */             fy = 1.0F - f;
/* 198 */             fz = f;
/*     */             break;
/*     */ 
/*     */           
/*     */           case 4:
/* 203 */             fx2 = 1.0F - f;
/* 204 */             fz = 1.0F - f;
/*     */             break;
/*     */ 
/*     */           
/*     */           case 5:
/* 209 */             fx = f;
/* 210 */             fz = 1.0F - f;
/*     */             break;
/*     */           
/*     */           default:
/* 214 */             fz = 1.0F - f;
/*     */             break;
/*     */         } 
/*     */       } 
/* 218 */       renderer.func_147782_a((fx + 1.0E-4F), (fy + 1.0E-4F), (fz + 1.0E-4F), (fx2 - 1.0E-4F), (fy2 - 1.0E-4F), (fz2 - 1.0E-4F));
/* 219 */       renderer.func_147784_q(block, i, j, k);
/*     */     }
/*     */     else {
/*     */       
/* 223 */       if (side == 0) {
/*     */         
/* 225 */         fy = 1.0F - f;
/* 226 */         switch (hinge) {
/*     */           
/*     */           case 0:
/* 229 */             fx = f;
/*     */             break;
/*     */           case 1:
/* 232 */             fz = f;
/*     */             break;
/*     */           case 2:
/* 235 */             fx2 = 1.0F - f;
/*     */             break;
/*     */           case 3:
/* 238 */             fz2 = 1.0F - f;
/*     */             break;
/*     */         } 
/*     */       
/* 242 */       } else if (side == 1) {
/*     */         
/* 244 */         fy2 = f;
/* 245 */         switch (hinge) {
/*     */           
/*     */           case 0:
/* 248 */             fx = f;
/*     */             break;
/*     */           case 1:
/* 251 */             fz = f;
/*     */             break;
/*     */           case 2:
/* 254 */             fx2 = 1.0F - f;
/*     */             break;
/*     */           case 3:
/* 257 */             fz2 = 1.0F - f;
/*     */             break;
/*     */         } 
/*     */       
/* 261 */       } else if (side == 2) {
/*     */         
/* 263 */         fz = 1.0F - f;
/* 264 */         switch (hinge) {
/*     */           
/*     */           case 0:
/* 267 */             fx = f;
/*     */             break;
/*     */           case 1:
/* 270 */             fy = f;
/*     */             break;
/*     */           case 2:
/* 273 */             fx2 = 1.0F - f;
/*     */             break;
/*     */           case 3:
/* 276 */             fy2 = 1.0F - f;
/*     */             break;
/*     */         } 
/*     */       
/* 280 */       } else if (side == 3) {
/*     */         
/* 282 */         fz2 = f;
/* 283 */         switch (hinge) {
/*     */           
/*     */           case 0:
/* 286 */             fx = f;
/*     */             break;
/*     */           case 1:
/* 289 */             fy = f;
/*     */             break;
/*     */           case 2:
/* 292 */             fx2 = 1.0F - f;
/*     */             break;
/*     */           case 3:
/* 295 */             fy2 = 1.0F - f;
/*     */             break;
/*     */         } 
/*     */       
/* 299 */       } else if (side == 4) {
/*     */         
/* 301 */         fx = 1.0F - f;
/* 302 */         switch (hinge) {
/*     */           
/*     */           case 0:
/* 305 */             fy = f;
/*     */             break;
/*     */           case 1:
/* 308 */             fz = f;
/*     */             break;
/*     */           case 2:
/* 311 */             fy2 = 1.0F - f;
/*     */             break;
/*     */           case 3:
/* 314 */             fz2 = 1.0F - f;
/*     */             break;
/*     */         } 
/*     */       
/* 318 */       } else if (side == 5) {
/*     */         
/* 320 */         fx2 = f;
/* 321 */         switch (hinge) {
/*     */           
/*     */           case 0:
/* 324 */             fy = f;
/*     */             break;
/*     */           case 1:
/* 327 */             fz = f;
/*     */             break;
/*     */           case 2:
/* 330 */             fy2 = 1.0F - f;
/*     */             break;
/*     */           case 3:
/* 333 */             fz2 = 1.0F - f;
/*     */             break;
/*     */         } 
/*     */       } 
/* 337 */       renderer.func_147782_a(fx, fy, fz, fx2, fy2, fz2);
/* 338 */       renderer.func_147784_q(block, i, j, k);
/*     */     } 
/*     */     
/* 341 */     int hingeID = (te.sheetStack != null) ? Math.min(((BlockMetalSheet)TFCBlocks.metalSheet).icons.length - 1, te.sheetStack.func_77960_j() >> 5) : 0;
/*     */     
/* 343 */     boolean breaking = (renderer.field_147840_d != null);
/*     */     
/* 345 */     if (!breaking) {
/* 346 */       renderer.func_147757_a(((BlockMetalSheet)TFCBlocks.metalSheet).icons[hingeID]);
/*     */     }
/* 348 */     drawHinges(block, i, j, k, renderer, side, hinge);
/*     */     
/* 350 */     if (!breaking) {
/* 351 */       renderer.func_147771_a();
/*     */     }
/* 353 */     renderer.field_147837_f = false;
/* 354 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static void drawHinges(Block block, int i, int j, int k, RenderBlocks renderer, int side, int hinge) {
/* 360 */     float f = 0.0625F;
/* 361 */     float f3 = f / 2.0F;
/*     */     
/* 363 */     float hingeMin = 0.0F;
/* 364 */     float hingeMin2 = f + f3;
/* 365 */     float hingeMax = 1.0F - f - f3;
/* 366 */     float hingeMax2 = 1.0F;
/*     */     
/* 368 */     if (hinge == 0) {
/*     */       
/* 370 */       switch (side) {
/*     */ 
/*     */         
/*     */         case 0:
/* 374 */           renderer.func_147782_a(hingeMin, hingeMax, 0.1D, hingeMin2, hingeMax2, 0.4D);
/* 375 */           renderer.func_147784_q(block, i, j, k);
/* 376 */           renderer.func_147782_a(hingeMin, hingeMax, 0.6D, hingeMin2, hingeMax2, 0.9D);
/* 377 */           renderer.func_147784_q(block, i, j, k);
/*     */           break;
/*     */ 
/*     */         
/*     */         case 1:
/* 382 */           renderer.func_147782_a(hingeMin, hingeMin, 0.1D, hingeMin2, hingeMin2, 0.4D);
/* 383 */           renderer.func_147784_q(block, i, j, k);
/* 384 */           renderer.func_147782_a(hingeMin, hingeMin, 0.6D, hingeMin2, hingeMin2, 0.9D);
/* 385 */           renderer.func_147784_q(block, i, j, k);
/*     */           break;
/*     */ 
/*     */         
/*     */         case 2:
/* 390 */           renderer.func_147782_a(hingeMin, 0.1D, hingeMax, hingeMin2, 0.4D, hingeMax2);
/* 391 */           renderer.func_147784_q(block, i, j, k);
/* 392 */           renderer.func_147782_a(hingeMin, 0.6D, hingeMax, hingeMin2, 0.9D, hingeMax2);
/* 393 */           renderer.func_147784_q(block, i, j, k);
/*     */           break;
/*     */ 
/*     */         
/*     */         case 3:
/* 398 */           renderer.func_147782_a(hingeMin, 0.1D, hingeMin, hingeMin2, 0.4D, hingeMin2);
/* 399 */           renderer.func_147784_q(block, i, j, k);
/* 400 */           renderer.func_147782_a(hingeMin, 0.6D, hingeMin, hingeMin2, 0.9D, hingeMin2);
/* 401 */           renderer.func_147784_q(block, i, j, k);
/*     */           break;
/*     */ 
/*     */         
/*     */         case 4:
/* 406 */           renderer.func_147782_a(hingeMax, hingeMin, 0.1D, hingeMax2, hingeMin2, 0.4D);
/* 407 */           renderer.func_147784_q(block, i, j, k);
/* 408 */           renderer.func_147782_a(hingeMax, hingeMin, 0.6D, hingeMax2, hingeMin2, 0.9D);
/* 409 */           renderer.func_147784_q(block, i, j, k);
/*     */           break;
/*     */ 
/*     */         
/*     */         case 5:
/* 414 */           renderer.func_147782_a(hingeMin, hingeMin, 0.1D, hingeMin2, hingeMin2, 0.4D);
/* 415 */           renderer.func_147784_q(block, i, j, k);
/* 416 */           renderer.func_147782_a(hingeMin, hingeMin, 0.6D, hingeMin2, hingeMin2, 0.9D);
/* 417 */           renderer.func_147784_q(block, i, j, k);
/*     */           break;
/*     */       } 
/*     */ 
/*     */     
/* 422 */     } else if (hinge == 1) {
/*     */       
/* 424 */       switch (side) {
/*     */ 
/*     */         
/*     */         case 0:
/* 428 */           renderer.func_147782_a(0.1D, hingeMax, hingeMin, 0.4D, hingeMax2, hingeMin2);
/* 429 */           renderer.func_147784_q(block, i, j, k);
/* 430 */           renderer.func_147782_a(0.6D, hingeMax, hingeMin, 0.9D, hingeMax2, hingeMin2);
/* 431 */           renderer.func_147784_q(block, i, j, k);
/*     */           break;
/*     */ 
/*     */         
/*     */         case 1:
/* 436 */           renderer.func_147782_a(0.1D, hingeMin, hingeMin, 0.4D, hingeMin2, hingeMin2);
/* 437 */           renderer.func_147784_q(block, i, j, k);
/* 438 */           renderer.func_147782_a(0.6D, hingeMin, hingeMin, 0.9D, hingeMin2, hingeMin2);
/* 439 */           renderer.func_147784_q(block, i, j, k);
/*     */           break;
/*     */ 
/*     */         
/*     */         case 2:
/* 444 */           renderer.func_147782_a(0.1D, hingeMin, hingeMax, 0.4D, hingeMin2, hingeMax2);
/* 445 */           renderer.func_147784_q(block, i, j, k);
/* 446 */           renderer.func_147782_a(0.6D, hingeMin, hingeMax, 0.9D, hingeMin2, hingeMax2);
/* 447 */           renderer.func_147784_q(block, i, j, k);
/*     */           break;
/*     */ 
/*     */         
/*     */         case 3:
/* 452 */           renderer.func_147782_a(0.1D, hingeMin, hingeMin, 0.4D, hingeMin2, hingeMin2);
/* 453 */           renderer.func_147784_q(block, i, j, k);
/* 454 */           renderer.func_147782_a(0.6D, hingeMin, hingeMin, 0.9D, hingeMin2, hingeMin2);
/* 455 */           renderer.func_147784_q(block, i, j, k);
/*     */           break;
/*     */ 
/*     */         
/*     */         case 4:
/* 460 */           renderer.func_147782_a(hingeMax, 0.1D, hingeMin, hingeMax2, 0.4D, hingeMin2);
/* 461 */           renderer.func_147784_q(block, i, j, k);
/* 462 */           renderer.func_147782_a(hingeMax, 0.6D, hingeMin, hingeMax2, 0.9D, hingeMin2);
/* 463 */           renderer.func_147784_q(block, i, j, k);
/*     */           break;
/*     */ 
/*     */         
/*     */         case 5:
/* 468 */           renderer.func_147782_a(hingeMin, 0.1D, hingeMin, hingeMin2, 0.4D, hingeMin2);
/* 469 */           renderer.func_147784_q(block, i, j, k);
/* 470 */           renderer.func_147782_a(hingeMin, 0.6D, hingeMin, hingeMin2, 0.9D, hingeMin2);
/* 471 */           renderer.func_147784_q(block, i, j, k);
/*     */           break;
/*     */       } 
/*     */ 
/*     */     
/* 476 */     } else if (hinge == 2) {
/*     */       
/* 478 */       switch (side) {
/*     */ 
/*     */         
/*     */         case 0:
/* 482 */           renderer.func_147782_a(hingeMax, hingeMax, 0.1D, hingeMax2, hingeMax2, 0.4D);
/* 483 */           renderer.func_147784_q(block, i, j, k);
/* 484 */           renderer.func_147782_a(hingeMax, hingeMax, 0.6D, hingeMax2, hingeMax2, 0.9D);
/* 485 */           renderer.func_147784_q(block, i, j, k);
/*     */           break;
/*     */ 
/*     */         
/*     */         case 1:
/* 490 */           renderer.func_147782_a(hingeMax, hingeMin, 0.1D, hingeMax2, hingeMin2, 0.4D);
/* 491 */           renderer.func_147784_q(block, i, j, k);
/* 492 */           renderer.func_147782_a(hingeMax, hingeMin, 0.6D, hingeMax2, hingeMin2, 0.9D);
/* 493 */           renderer.func_147784_q(block, i, j, k);
/*     */           break;
/*     */ 
/*     */         
/*     */         case 2:
/* 498 */           renderer.func_147782_a(hingeMax, 0.1D, hingeMax, hingeMax2, 0.4D, hingeMax2);
/* 499 */           renderer.func_147784_q(block, i, j, k);
/* 500 */           renderer.func_147782_a(hingeMax, 0.6D, hingeMax, hingeMax2, 0.9D, hingeMax2);
/* 501 */           renderer.func_147784_q(block, i, j, k);
/*     */           break;
/*     */ 
/*     */         
/*     */         case 3:
/* 506 */           renderer.func_147782_a(hingeMax, 0.1D, hingeMin, hingeMax2, 0.4D, hingeMin2);
/* 507 */           renderer.func_147784_q(block, i, j, k);
/* 508 */           renderer.func_147782_a(hingeMax, 0.6D, hingeMin, hingeMax2, 0.9D, hingeMin2);
/* 509 */           renderer.func_147784_q(block, i, j, k);
/*     */           break;
/*     */ 
/*     */         
/*     */         case 4:
/* 514 */           renderer.func_147782_a(hingeMax, hingeMax, 0.1D, hingeMax2, hingeMax2, 0.4D);
/* 515 */           renderer.func_147784_q(block, i, j, k);
/* 516 */           renderer.func_147782_a(hingeMax, hingeMax, 0.6D, hingeMax2, hingeMax2, 0.9D);
/* 517 */           renderer.func_147784_q(block, i, j, k);
/*     */           break;
/*     */ 
/*     */         
/*     */         case 5:
/* 522 */           renderer.func_147782_a(hingeMin, hingeMax, 0.1D, hingeMin2, hingeMax2, 0.4D);
/* 523 */           renderer.func_147784_q(block, i, j, k);
/* 524 */           renderer.func_147782_a(hingeMin, hingeMax, 0.6D, hingeMin2, hingeMax2, 0.9D);
/* 525 */           renderer.func_147784_q(block, i, j, k);
/*     */           break;
/*     */       } 
/*     */ 
/*     */     
/* 530 */     } else if (hinge == 3) {
/*     */       
/* 532 */       switch (side) {
/*     */ 
/*     */         
/*     */         case 0:
/* 536 */           renderer.func_147782_a(0.1D, hingeMax, hingeMax, 0.4D, hingeMax2, hingeMax2);
/* 537 */           renderer.func_147784_q(block, i, j, k);
/* 538 */           renderer.func_147782_a(0.6D, hingeMax, hingeMax, 0.9D, hingeMax2, hingeMax2);
/* 539 */           renderer.func_147784_q(block, i, j, k);
/*     */           break;
/*     */ 
/*     */         
/*     */         case 1:
/* 544 */           renderer.func_147782_a(0.1D, hingeMin, hingeMax, 0.4D, hingeMin2, hingeMax2);
/* 545 */           renderer.func_147784_q(block, i, j, k);
/* 546 */           renderer.func_147782_a(0.6D, hingeMin, hingeMax, 0.9D, hingeMin2, hingeMax2);
/* 547 */           renderer.func_147784_q(block, i, j, k);
/*     */           break;
/*     */ 
/*     */         
/*     */         case 2:
/* 552 */           renderer.func_147782_a(0.1D, hingeMax, hingeMax, 0.4D, hingeMax2, hingeMax2);
/* 553 */           renderer.func_147784_q(block, i, j, k);
/* 554 */           renderer.func_147782_a(0.6D, hingeMax, hingeMax, 0.9D, hingeMax2, hingeMax2);
/* 555 */           renderer.func_147784_q(block, i, j, k);
/*     */           break;
/*     */ 
/*     */         
/*     */         case 3:
/* 560 */           renderer.func_147782_a(0.1D, hingeMax, hingeMin, 0.4D, hingeMax2, hingeMin2);
/* 561 */           renderer.func_147784_q(block, i, j, k);
/* 562 */           renderer.func_147782_a(0.6D, hingeMax, hingeMin, 0.9D, hingeMax2, hingeMin2);
/* 563 */           renderer.func_147784_q(block, i, j, k);
/*     */           break;
/*     */ 
/*     */         
/*     */         case 4:
/* 568 */           renderer.func_147782_a(hingeMax, 0.1D, hingeMax, hingeMax2, 0.4D, hingeMax2);
/* 569 */           renderer.func_147784_q(block, i, j, k);
/* 570 */           renderer.func_147782_a(hingeMax, 0.6D, hingeMax, hingeMax2, 0.9D, hingeMax2);
/* 571 */           renderer.func_147784_q(block, i, j, k);
/*     */           break;
/*     */ 
/*     */         
/*     */         case 5:
/* 576 */           renderer.func_147782_a(hingeMin, 0.1D, hingeMax, hingeMin2, 0.4D, hingeMax2);
/* 577 */           renderer.func_147784_q(block, i, j, k);
/* 578 */           renderer.func_147782_a(hingeMin, 0.6D, hingeMax, hingeMin2, 0.9D, hingeMax2);
/* 579 */           renderer.func_147784_q(block, i, j, k);
/*     */           break;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {
/* 589 */     renderer.func_147782_a(0.125D, 0.4000000059604645D, 0.0D, 1.0D, 0.4749999940395355D, 1.0D);
/* 590 */     renderInvBlock(block, metadata & 0xFF, renderer);
/* 591 */     renderer.func_147782_a(0.0D, 0.4000000059604645D, 0.10000000149011612D, 0.125D, 0.5249999761581421D, 0.4000000059604645D);
/* 592 */     int index = Math.min(((BlockMetalSheet)TFCBlocks.metalSheet).icons.length - 1, metadata >> 5);
/* 593 */     renderInvBlock(block, ((BlockMetalSheet)TFCBlocks.metalSheet).icons[index], renderer);
/* 594 */     renderer.func_147782_a(0.0D, 0.4000000059604645D, 0.6000000238418579D, 0.125D, 0.5249999761581421D, 0.8999999761581421D);
/* 595 */     renderInvBlock(block, ((BlockMetalSheet)TFCBlocks.metalSheet).icons[index], renderer);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
/* 601 */     return render(block, x, y, z, renderer);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean shouldRender3DInInventory(int modelId) {
/* 607 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRenderId() {
/* 613 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void renderInvBlock(Block block, int meta, RenderBlocks renderer) {
/* 618 */     Tessellator var14 = Tessellator.field_78398_a;
/* 619 */     var14.func_78382_b();
/* 620 */     var14.func_78375_b(0.0F, -1.0F, 0.0F);
/* 621 */     renderer.func_147768_a(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(0, meta));
/* 622 */     var14.func_78381_a();
/* 623 */     var14.func_78382_b();
/* 624 */     var14.func_78375_b(0.0F, 1.0F, 0.0F);
/* 625 */     renderer.func_147806_b(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(1, meta));
/* 626 */     var14.func_78381_a();
/* 627 */     var14.func_78382_b();
/* 628 */     var14.func_78375_b(0.0F, 0.0F, -1.0F);
/* 629 */     renderer.func_147798_e(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(2, meta));
/* 630 */     var14.func_78381_a();
/* 631 */     var14.func_78382_b();
/* 632 */     var14.func_78375_b(0.0F, 0.0F, 1.0F);
/* 633 */     renderer.func_147764_f(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(3, meta));
/* 634 */     var14.func_78381_a();
/* 635 */     var14.func_78382_b();
/* 636 */     var14.func_78375_b(-1.0F, 0.0F, 0.0F);
/* 637 */     renderer.func_147761_c(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(4, meta));
/* 638 */     var14.func_78381_a();
/* 639 */     var14.func_78382_b();
/* 640 */     var14.func_78375_b(1.0F, 0.0F, 0.0F);
/* 641 */     renderer.func_147734_d(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(5, meta));
/* 642 */     var14.func_78381_a();
/*     */   }
/*     */ 
/*     */   
/*     */   public static void renderInvBlock(Block block, IIcon ico, RenderBlocks renderer) {
/* 647 */     Tessellator var14 = Tessellator.field_78398_a;
/* 648 */     var14.func_78382_b();
/* 649 */     var14.func_78375_b(0.0F, -1.0F, 0.0F);
/* 650 */     renderer.func_147768_a(block, 0.0D, 0.0D, 0.0D, ico);
/* 651 */     var14.func_78381_a();
/* 652 */     var14.func_78382_b();
/* 653 */     var14.func_78375_b(0.0F, 1.0F, 0.0F);
/* 654 */     renderer.func_147806_b(block, 0.0D, 0.0D, 0.0D, ico);
/* 655 */     var14.func_78381_a();
/* 656 */     var14.func_78382_b();
/* 657 */     var14.func_78375_b(0.0F, 0.0F, -1.0F);
/* 658 */     renderer.func_147798_e(block, 0.0D, 0.0D, 0.0D, ico);
/* 659 */     var14.func_78381_a();
/* 660 */     var14.func_78382_b();
/* 661 */     var14.func_78375_b(0.0F, 0.0F, 1.0F);
/* 662 */     renderer.func_147764_f(block, 0.0D, 0.0D, 0.0D, ico);
/* 663 */     var14.func_78381_a();
/* 664 */     var14.func_78382_b();
/* 665 */     var14.func_78375_b(-1.0F, 0.0F, 0.0F);
/* 666 */     renderer.func_147761_c(block, 0.0D, 0.0D, 0.0D, ico);
/* 667 */     var14.func_78381_a();
/* 668 */     var14.func_78382_b();
/* 669 */     var14.func_78375_b(1.0F, 0.0F, 0.0F);
/* 670 */     renderer.func_147734_d(block, 0.0D, 0.0D, 0.0D, ico);
/* 671 */     var14.func_78381_a();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Render\Blocks\RenderMetalTrapDoor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
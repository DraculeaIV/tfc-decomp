/*     */ package com.bioxx.tfc.Items.Tools;
/*     */ 
/*     */ import com.bioxx.tfc.Items.ItemTerra;
/*     */ import com.bioxx.tfc.api.Enums.EnumItemReach;
/*     */ import com.bioxx.tfc.api.Enums.EnumSize;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import com.bioxx.tfc.api.Util.Helper;
/*     */ import cpw.mods.fml.common.eventhandler.Event;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.MinecraftForge;
/*     */ import net.minecraftforge.event.entity.player.FillBucketEvent;
/*     */ import net.minecraftforge.fluids.Fluid;
/*     */ import net.minecraftforge.fluids.FluidContainerRegistry;
/*     */ import net.minecraftforge.fluids.FluidStack;
/*     */ import net.minecraftforge.fluids.IFluidBlock;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemSteelBucket
/*     */   extends ItemTerra
/*     */ {
/*     */   protected Block bucketContents;
/*     */   
/*     */   public ItemSteelBucket(Block par2) {
/*  34 */     this.bucketContents = par2;
/*  35 */     setFolder("tools/");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumSize getSize(ItemStack is) {
/*  41 */     return EnumSize.LARGE;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canStack() {
/*  47 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_77659_a(ItemStack is, World world, EntityPlayer player) {
/*  57 */     boolean var11 = (this.bucketContents == Blocks.field_150350_a);
/*  58 */     MovingObjectPosition mop = Helper.getMovingObjectPositionFromPlayer(world, (EntityLivingBase)player, var11);
/*     */     
/*  60 */     if (mop == null)
/*     */     {
/*  62 */       return is;
/*     */     }
/*     */ 
/*     */     
/*  66 */     FillBucketEvent event = new FillBucketEvent(player, is, world, mop);
/*  67 */     if (MinecraftForge.EVENT_BUS.post((Event)event))
/*     */     {
/*  69 */       return is;
/*     */     }
/*     */     
/*  72 */     if (event.getResult() == Event.Result.ALLOW) {
/*     */       
/*  74 */       if (player.field_71075_bZ.field_75098_d)
/*     */       {
/*  76 */         return is;
/*     */       }
/*     */       
/*  79 */       if (--is.field_77994_a <= 0)
/*     */       {
/*  81 */         return event.result;
/*     */       }
/*     */       
/*  84 */       if (!player.field_71071_by.func_70441_a(event.result))
/*     */       {
/*  86 */         player.func_71019_a(event.result, false);
/*     */       }
/*     */       
/*  89 */       return is;
/*     */     } 
/*  91 */     if (mop.field_72313_a == MovingObjectPosition.MovingObjectType.BLOCK) {
/*     */       
/*  93 */       int i = mop.field_72311_b;
/*  94 */       int j = mop.field_72312_c;
/*  95 */       int k = mop.field_72309_d;
/*     */ 
/*     */ 
/*     */       
/*  99 */       if (!world.func_72962_a(player, i, j, k))
/*     */       {
/* 101 */         return is;
/*     */       }
/*     */       
/* 104 */       if (this.bucketContents == Blocks.field_150350_a) {
/*     */         
/* 106 */         if (!player.func_82247_a(i, j, k, mop.field_72310_e, is) || !(world.func_147439_a(i, j, k) instanceof IFluidBlock))
/*     */         {
/* 108 */           return is;
/*     */         }
/*     */         
/* 111 */         Fluid fluid = ((IFluidBlock)world.func_147439_a(i, j, k)).getFluid();
/* 112 */         if (fluid != null) {
/*     */           
/* 114 */           ItemStack filledIS = FluidContainerRegistry.fillFluidContainer(new FluidStack(fluid, 1000), is);
/* 115 */           if (filledIS != null)
/*     */           {
/* 117 */             world.func_147468_f(i, j, k);
/*     */             
/* 119 */             if (--is.field_77994_a <= 0)
/*     */             {
/* 121 */               return filledIS;
/*     */             }
/*     */             
/* 124 */             if (!player.field_71071_by.func_70441_a(filledIS))
/*     */             {
/* 126 */               player.func_70099_a(filledIS, 0.0F);
/*     */             }
/*     */             
/* 129 */             return is;
/*     */           }
/*     */         
/*     */         } 
/*     */       } else {
/*     */         
/* 135 */         if (this.bucketContents == Blocks.field_150350_a)
/*     */         {
/* 137 */           return getContainerItem(is);
/*     */         }
/*     */         
/* 140 */         if (mop.field_72310_e == 0) j--; 
/* 141 */         if (mop.field_72310_e == 1) j++; 
/* 142 */         if (mop.field_72310_e == 2) k--; 
/* 143 */         if (mop.field_72310_e == 3) k++; 
/* 144 */         if (mop.field_72310_e == 4) i--; 
/* 145 */         if (mop.field_72310_e == 5) i++;
/*     */         
/* 147 */         if (!player.func_82247_a(i, j, k, mop.field_72310_e, is))
/*     */         {
/* 149 */           return is;
/*     */         }
/*     */         
/* 152 */         if (tryPlaceContainedLiquid(world, i, j, k) && !player.field_71075_bZ.field_75098_d)
/*     */         {
/* 154 */           return getContainerItem(is);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 159 */     return is;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean tryPlaceContainedLiquid(World world, int x, int y, int z) {
/* 167 */     if (this.bucketContents == Blocks.field_150350_a)
/*     */     {
/* 169 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 173 */     Material material = world.func_147439_a(x, y, z).func_149688_o();
/* 174 */     boolean flag = !material.func_76220_a();
/*     */     
/* 176 */     if (!world.func_147437_c(x, y, z) && !flag)
/*     */     {
/* 178 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 182 */     if (world.field_73011_w.field_76575_d && (this.bucketContents == TFCBlocks.freshWater || this.bucketContents == TFCBlocks.saltWater)) {
/*     */       
/* 184 */       world.func_72908_a((x + 0.5F), (y + 0.5F), (z + 0.5F), "random.fizz", 0.5F, 2.6F + (world.field_73012_v.nextFloat() - world.field_73012_v.nextFloat()) * 0.8F);
/*     */       
/* 186 */       for (int l = 0; l < 8; l++)
/*     */       {
/* 188 */         world.func_72869_a("largesmoke", x + Math.random(), y + Math.random(), z + Math.random(), 0.0D, 0.0D, 0.0D);
/*     */       }
/*     */     }
/*     */     else {
/*     */       
/* 193 */       if (!world.field_72995_K && flag && !material.func_76224_d())
/*     */       {
/* 195 */         world.func_147480_a(x, y, z, true);
/*     */       }
/*     */       
/* 198 */       world.func_147465_d(x, y, z, this.bucketContents, 0, 3);
/*     */     } 
/*     */     
/* 201 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumItemReach getReach(ItemStack is) {
/* 209 */     return EnumItemReach.SHORT;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\Tools\ItemSteelBucket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
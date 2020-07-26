/*     */ package com.bioxx.tfc.Items.ItemBlocks;
/*     */ 
/*     */ import com.bioxx.tfc.TileEntities.TEMetalTrapDoor;
/*     */ import com.bioxx.tfc.api.Enums.EnumSize;
/*     */ import com.bioxx.tfc.api.TFCBlocks;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ public class ItemMetalTrapDoor
/*     */   extends ItemTerraBlock
/*     */ {
/*     */   public ItemMetalTrapDoor(Block par1) {
/*  16 */     super(par1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_77648_a(ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
/*  22 */     if (!world.field_72995_K) {
/*     */       
/*  24 */       int out = side;
/*  25 */       int hinge = 0;
/*  26 */       switch (side) {
/*     */ 
/*     */         
/*     */         case 0:
/*  30 */           y--;
/*  31 */           if (hitX < 0.2D)
/*  32 */           { hinge = 0; }
/*  33 */           else if (hitZ < 0.2D)
/*  34 */           { hinge = 1; }
/*  35 */           else if (hitX > 0.8D)
/*  36 */           { hinge = 2; }
/*  37 */           else if (hitZ > 0.8D)
/*  38 */           { hinge = 3; }
/*  39 */           else { return false; }
/*     */           
/*  41 */           out += hinge << 4;
/*     */           break;
/*     */ 
/*     */         
/*     */         case 1:
/*  46 */           y++;
/*  47 */           if (hitX < 0.2D)
/*  48 */           { hinge = 0; }
/*  49 */           else if (hitZ < 0.2D)
/*  50 */           { hinge = 1; }
/*  51 */           else if (hitX > 0.8D)
/*  52 */           { hinge = 2; }
/*  53 */           else if (hitZ > 0.8D)
/*  54 */           { hinge = 3; }
/*  55 */           else { return false; }
/*     */           
/*  57 */           out += hinge << 4;
/*     */           break;
/*     */ 
/*     */         
/*     */         case 2:
/*  62 */           z--;
/*  63 */           if (hitX < 0.2D)
/*  64 */           { hinge = 0; }
/*  65 */           else if (hitY < 0.2D)
/*  66 */           { hinge = 1; }
/*  67 */           else if (hitX > 0.8D)
/*  68 */           { hinge = 2; }
/*  69 */           else if (hitY > 0.8D)
/*  70 */           { hinge = 3; }
/*  71 */           else { return false; }
/*     */           
/*  73 */           out += hinge << 4;
/*     */           break;
/*     */ 
/*     */         
/*     */         case 3:
/*  78 */           z++;
/*  79 */           if (hitX < 0.2D)
/*  80 */           { hinge = 0; }
/*  81 */           else if (hitY < 0.2D)
/*  82 */           { hinge = 1; }
/*  83 */           else if (hitX > 0.8D)
/*  84 */           { hinge = 2; }
/*  85 */           else if (hitY > 0.8D)
/*  86 */           { hinge = 3; }
/*  87 */           else { return false; }
/*     */           
/*  89 */           out += hinge << 4;
/*     */           break;
/*     */         
/*     */         case 4:
/*  93 */           x--;
/*  94 */           if (hitY < 0.2D)
/*  95 */           { hinge = 0; }
/*  96 */           else if (hitZ < 0.2D)
/*  97 */           { hinge = 1; }
/*  98 */           else if (hitY > 0.8D)
/*  99 */           { hinge = 2; }
/* 100 */           else if (hitZ > 0.8D)
/* 101 */           { hinge = 3; }
/* 102 */           else { return false; }
/*     */           
/* 104 */           out += hinge << 4;
/*     */           break;
/*     */         
/*     */         case 5:
/* 108 */           x++;
/* 109 */           if (hitY < 0.2D)
/* 110 */           { hinge = 0; }
/* 111 */           else if (hitZ < 0.2D)
/* 112 */           { hinge = 1; }
/* 113 */           else if (hitY > 0.8D)
/* 114 */           { hinge = 2; }
/* 115 */           else if (hitZ > 0.8D)
/* 116 */           { hinge = 3; }
/* 117 */           else { return false; }
/*     */           
/* 119 */           out += hinge << 4;
/*     */           break;
/*     */       } 
/*     */       
/* 123 */       if (world.func_147439_a(x, y, z).func_149688_o().func_76222_j())
/*     */       {
/* 125 */         if (world.func_147449_b(x, y, z, TFCBlocks.metalTrapDoor)) {
/*     */           
/* 127 */           TEMetalTrapDoor te = (TEMetalTrapDoor)world.func_147438_o(x, y, z);
/* 128 */           te.sheetStack = itemstack.func_77946_l();
/* 129 */           te.sheetStack.field_77994_a = 1;
/* 130 */           te.data = (byte)out;
/* 131 */           itemstack.field_77994_a--;
/* 132 */           return true;
/*     */         } 
/*     */       }
/*     */     } 
/* 136 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public EnumSize getSize(ItemStack is) {
/* 141 */     return EnumSize.HUGE;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Items\ItemBlocks\ItemMetalTrapDoor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
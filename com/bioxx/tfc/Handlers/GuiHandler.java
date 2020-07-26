/*     */ package com.bioxx.tfc.Handlers;
/*     */ import com.bioxx.tfc.Containers.ContainerBarrel;
/*     */ import com.bioxx.tfc.Containers.ContainerFoodPrep;
/*     */ import com.bioxx.tfc.Containers.ContainerLargeVessel;
/*     */ import com.bioxx.tfc.Containers.ContainerPlanSelection;
/*     */ import com.bioxx.tfc.Containers.ContainerPlayerTFC;
/*     */ import com.bioxx.tfc.Core.Player.PlayerInfo;
/*     */ import com.bioxx.tfc.Entities.Mobs.EntityHorseTFC;
/*     */ import com.bioxx.tfc.TileEntities.TEAnvil;
/*     */ import com.bioxx.tfc.TileEntities.TEBarrel;
/*     */ import com.bioxx.tfc.TileEntities.TEFoodPrep;
/*     */ import com.bioxx.tfc.TileEntities.TEVessel;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class GuiHandler implements IGuiHandler {
/*     */   public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
/*     */     PlayerInfo pi;
/*  21 */     TileEntity te = world.func_147438_o(x, y, z);
/*     */     
/*  23 */     switch (id) {
/*     */ 
/*     */       
/*     */       case 0:
/*  27 */         return new ContainerLogPile(player.field_71071_by, (TELogPile)te, world, x, y, z);
/*     */ 
/*     */       
/*     */       case 1:
/*  31 */         return new ContainerWorkbench(player.field_71071_by, (TEWorkbench)te, world, x, y, z);
/*     */ 
/*     */       
/*     */       case 19:
/*  35 */         return new ContainerLiquidVessel(player.field_71071_by, world, x, y, z);
/*     */ 
/*     */       
/*     */       case 20:
/*  39 */         return new ContainerFirepit(player.field_71071_by, (TEFirepit)te, world, x, y, z);
/*     */ 
/*     */       
/*     */       case 21:
/*  43 */         return new ContainerAnvil(player.field_71071_by, (TEAnvil)te, world, x, y, z);
/*     */ 
/*     */       
/*     */       case 22:
/*  47 */         return null;
/*     */ 
/*     */       
/*     */       case 23:
/*  51 */         return new ContainerForge(player.field_71071_by, (TEForge)te, world, x, y, z);
/*     */ 
/*     */       
/*     */       case 24:
/*  55 */         return new ContainerPlanSelection(player, (TEAnvil)te, world, x, y, z);
/*     */ 
/*     */       
/*     */       case 25:
/*  59 */         return new ContainerSluice(player.field_71071_by, (TESluice)te, world, x, y, z);
/*     */ 
/*     */       
/*     */       case 26:
/*  63 */         return new ContainerBlastFurnace(player.field_71071_by, (TEBlastFurnace)te, world, x, y, z);
/*     */ 
/*     */       
/*     */       case 28:
/*  67 */         pi = PlayerManagerTFC.getInstance().getPlayerInfoFromPlayer(player);
/*  68 */         return new ContainerSpecialCrafting(player.field_71071_by, (pi.specialCraftingTypeAlternate == null) ? pi.specialCraftingType : null, world, x, y, z);
/*     */ 
/*     */       
/*     */       case 29:
/*  72 */         return new ContainerChestTFC((IInventory)player.field_71071_by, (IInventory)te, world, x, y, z);
/*     */ 
/*     */       
/*     */       case 31:
/*  76 */         return new ContainerPlayerTFC(player.field_71071_by, false, player);
/*     */ 
/*     */       
/*     */       case 33:
/*  80 */         return new ContainerQuern(player.field_71071_by, (TEQuern)te, world, x, y, z);
/*     */ 
/*     */       
/*     */       case 34:
/*  84 */         return null;
/*     */ 
/*     */       
/*     */       case 35:
/*  88 */         return new ContainerBarrel(player.field_71071_by, (TEBarrel)te, world, x, y, z, 0);
/*     */ 
/*     */       
/*     */       case 36:
/*  92 */         return new ContainerBarrel(player.field_71071_by, (TEBarrel)te, world, x, y, z, 1);
/*     */ 
/*     */       
/*     */       case 37:
/*  96 */         return new ContainerCrucible(player.field_71071_by, (TECrucible)te, world, x, y, z);
/*     */ 
/*     */       
/*     */       case 38:
/* 100 */         return new ContainerMold(player.field_71071_by, world, x, y, z);
/*     */ 
/*     */       
/*     */       case 39:
/* 104 */         return new ContainerVessel(player.field_71071_by, world, x, y, z);
/*     */ 
/*     */       
/*     */       case 40:
/* 108 */         return new ContainerQuiver(player.field_71071_by, world, x, y, z);
/*     */ 
/*     */       
/*     */       case 41:
/* 112 */         return new ContainerNestBox(player.field_71071_by, (TENestBox)te, world, x, y, z);
/*     */ 
/*     */       
/*     */       case 42:
/* 116 */         if (player.field_70154_o instanceof EntityHorseTFC) {
/*     */           
/* 118 */           EntityHorseTFC horse = (EntityHorseTFC)player.field_70154_o;
/* 119 */           return new ContainerHorseInventoryTFC(player.field_71071_by, (IInventory)horse.getHorseChest(), horse);
/*     */         } 
/*     */         
/* 122 */         return null;
/*     */ 
/*     */       
/*     */       case 43:
/* 126 */         return new ContainerGrill(player.field_71071_by, (TEGrill)te, world, x, y, z);
/*     */       
/*     */       case 44:
/* 129 */         return new ContainerFoodPrep(player.field_71071_by, (TEFoodPrep)te, world, x, y, z, 0);
/*     */       case 45:
/* 131 */         return new ContainerFoodPrep(player.field_71071_by, (TEFoodPrep)te, world, x, y, z, 1);
/*     */       case 46:
/* 133 */         return new ContainerLargeVessel(player.field_71071_by, (TEVessel)te, world, x, y, z, 0);
/*     */       case 47:
/* 135 */         return new ContainerLargeVessel(player.field_71071_by, (TEVessel)te, world, x, y, z, 1);
/*     */       
/*     */       case 48:
/* 138 */         return null;
/*     */ 
/*     */       
/*     */       case 49:
/* 142 */         return new ContainerHopper(player.field_71071_by, (IInventory)te);
/*     */     } 
/*     */ 
/*     */     
/* 146 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
/* 154 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Handlers\GuiHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
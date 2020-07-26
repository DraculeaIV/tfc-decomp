/*     */ package com.bioxx.tfc.Handlers.Client;
/*     */ import com.bioxx.tfc.Core.Player.PlayerInfo;
/*     */ import com.bioxx.tfc.Entities.Mobs.EntityHorseTFC;
/*     */ import com.bioxx.tfc.GUI.GuiAnvil;
/*     */ import com.bioxx.tfc.GUI.GuiBarrel;
/*     */ import com.bioxx.tfc.GUI.GuiChestTFC;
/*     */ import com.bioxx.tfc.GUI.GuiFoodPrep;
/*     */ import com.bioxx.tfc.GUI.GuiInventoryTFC;
/*     */ import com.bioxx.tfc.GUI.GuiLargeVessel;
/*     */ import com.bioxx.tfc.GUI.GuiWorkbench;
/*     */ import com.bioxx.tfc.TileEntities.TEAnvil;
/*     */ import com.bioxx.tfc.TileEntities.TEBarrel;
/*     */ import com.bioxx.tfc.TileEntities.TEFirepit;
/*     */ import com.bioxx.tfc.TileEntities.TEFoodPrep;
/*     */ import com.bioxx.tfc.TileEntities.TEVessel;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.client.event.GuiOpenEvent;
/*     */ 
/*     */ public class GuiHandler extends GuiHandler {
/*     */   public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
/*     */     TileEntity te;
/*     */     PlayerInfo pi;
/*     */     try {
/*  27 */       te = world.func_147438_o(x, y, z);
/*     */     }
/*  29 */     catch (Exception e) {
/*     */       
/*  31 */       te = null;
/*     */     } 
/*     */     
/*  34 */     switch (id) {
/*     */       
/*     */       case 0:
/*  37 */         return new GuiLogPile(player.field_71071_by, (TELogPile)te, world, x, y, z);
/*     */       case 1:
/*  39 */         return new GuiWorkbench(player.field_71071_by, (TEWorkbench)te, world, x, y, z);
/*     */       case 19:
/*  41 */         return new GuiVesselLiquid(player.field_71071_by, world, x, y, z);
/*     */       case 20:
/*  43 */         return new GuiFirepit(player.field_71071_by, (TEFirepit)te, world, x, y, z);
/*     */       case 21:
/*  45 */         return new GuiAnvil(player.field_71071_by, (TEAnvil)te, world, x, y, z);
/*     */       case 22:
/*  47 */         return null;
/*     */       case 23:
/*  49 */         return new GuiForge(player.field_71071_by, (TEForge)te, world, x, y, z);
/*     */       case 24:
/*  51 */         return new GuiPlanSelection(player, (TEAnvil)te, world, x, y, z);
/*     */       case 25:
/*  53 */         return new GuiSluice(player.field_71071_by, (TESluice)te, world, x, y, z);
/*     */       case 26:
/*  55 */         return new GuiBlastFurnace(player.field_71071_by, (TEBlastFurnace)te, world, x, y, z);
/*     */       case 27:
/*  57 */         return new GuiCalendar(player);
/*     */       case 28:
/*  59 */         pi = PlayerManagerTFC.getInstance().getPlayerInfoFromPlayer(player);
/*  60 */         return new GuiKnapping(player.field_71071_by, (pi.specialCraftingTypeAlternate == null) ? pi.specialCraftingType : null, world, x, y, z);
/*     */       case 29:
/*  62 */         return new GuiChestTFC((IInventory)player.field_71071_by, (IInventory)te, world, x, y, z);
/*     */       case 31:
/*  64 */         return new GuiInventoryTFC(player);
/*     */       
/*     */       case 32:
/*     */       case 33:
/*  68 */         return new GuiQuern(player.field_71071_by, (TEQuern)te, world, x, y, z);
/*     */       case 34:
/*  70 */         return new GuiBlueprint(player, world, x, y, z);
/*     */       case 35:
/*  72 */         return new GuiBarrel(player.field_71071_by, (TEBarrel)te, world, x, y, z, 0);
/*     */       case 36:
/*  74 */         return new GuiBarrel(player.field_71071_by, (TEBarrel)te, world, x, y, z, 1);
/*     */       case 37:
/*  76 */         return new GuiCrucible(player.field_71071_by, (TECrucible)te, world, x, y, z);
/*     */       case 38:
/*  78 */         return new GuiMold(player.field_71071_by, world, x, y, z);
/*     */       case 39:
/*  80 */         return new GuiVessel(player.field_71071_by, world, x, y, z);
/*     */       case 40:
/*  82 */         return new GuiQuiver(player.field_71071_by, world, x, y, z);
/*     */       case 41:
/*  84 */         return new GuiNestBox(player.field_71071_by, (TENestBox)te, world, x, y, z);
/*     */       
/*     */       case 42:
/*  87 */         if (player.field_70154_o instanceof EntityHorseTFC) {
/*     */           
/*  89 */           EntityHorseTFC horse = (EntityHorseTFC)player.field_70154_o;
/*  90 */           horse.updateChestSaddle();
/*  91 */           return new GuiScreenHorseInventoryTFC(player.field_71071_by, (IInventory)horse.getHorseChest(), horse);
/*     */         } 
/*     */         
/*  94 */         return null;
/*     */       
/*     */       case 43:
/*  97 */         return new GuiGrill(player.field_71071_by, (TEGrill)te, world, x, y, z);
/*     */       case 44:
/*  99 */         return new GuiFoodPrep(player.field_71071_by, (TEFoodPrep)te, world, x, y, z, 0);
/*     */       case 45:
/* 101 */         return new GuiFoodPrep(player.field_71071_by, (TEFoodPrep)te, world, x, y, z, 1);
/*     */       case 46:
/* 103 */         return new GuiLargeVessel(player.field_71071_by, (TEVessel)te, world, x, y, z, 0);
/*     */       case 47:
/* 105 */         return new GuiLargeVessel(player.field_71071_by, (TEVessel)te, world, x, y, z, 1);
/*     */       case 48:
/* 107 */         return new GuiCustomNametag(player, world, x, y, z);
/*     */       
/*     */       case 49:
/* 110 */         return new GuiHopper(player.field_71071_by, (TEHopper)te, world, x, y, z);
/*     */     } 
/*     */     
/* 113 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SubscribeEvent
/*     */   public void openGuiHandler(GuiOpenEvent event) {
/* 120 */     if (event.gui instanceof net.minecraft.client.gui.inventory.GuiInventory && !(event.gui instanceof GuiInventoryTFC))
/* 121 */       event.gui = (GuiScreen)new GuiInventoryTFC((EntityPlayer)(Minecraft.func_71410_x()).field_71439_g); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Handlers\Client\GuiHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
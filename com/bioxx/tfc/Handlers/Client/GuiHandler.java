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
/*     */ import com.bioxx.tfc.ModSupport.ShipsMod;
/*     */ import com.bioxx.tfc.TileEntities.TEAnvil;
/*     */ import com.bioxx.tfc.TileEntities.TEBarrel;
/*     */ import com.bioxx.tfc.TileEntities.TEFirepit;
/*     */ import com.bioxx.tfc.TileEntities.TEFoodPrep;
/*     */ import com.bioxx.tfc.TileEntities.TEForge;
/*     */ import com.bioxx.tfc.TileEntities.TEVessel;
/*     */ import cpw.mods.fml.common.Loader;
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
/*  30 */       te = world.func_147438_o(x, y, z);
/*  31 */       if (te == null && Loader.isModLoaded("cuchaz.ships"))
/*     */       {
/*  33 */         ShipsMod shipsMod = new ShipsMod();
/*  34 */         world = shipsMod.getShipsWorld(world, player.field_71071_by);
/*  35 */         te = world.func_147438_o(x, y, z);
/*     */       }
/*     */     
/*     */     }
/*  39 */     catch (Exception e) {
/*     */       
/*  41 */       te = null;
/*     */     } 
/*     */     
/*  44 */     switch (id) {
/*     */       
/*     */       case 0:
/*  47 */         return new GuiLogPile(player.field_71071_by, (TELogPile)te, world, x, y, z);
/*     */       case 1:
/*  49 */         return new GuiWorkbench(player.field_71071_by, (TEWorkbench)te, world, x, y, z);
/*     */       case 19:
/*  51 */         return new GuiVesselLiquid(player.field_71071_by, world, x, y, z);
/*     */       case 20:
/*  53 */         return new GuiFirepit(player.field_71071_by, (TEFirepit)te, world, x, y, z);
/*     */       case 21:
/*  55 */         return new GuiAnvil(player.field_71071_by, (TEAnvil)te, world, x, y, z);
/*     */       case 22:
/*  57 */         return null;
/*     */       case 23:
/*  59 */         return new GuiForge(player.field_71071_by, (TEForge)te, world, x, y, z);
/*     */       case 24:
/*  61 */         return new GuiPlanSelection(player, (TEAnvil)te, world, x, y, z);
/*     */       case 25:
/*  63 */         return new GuiSluice(player.field_71071_by, (TESluice)te, world, x, y, z);
/*     */       case 26:
/*  65 */         return new GuiBlastFurnace(player.field_71071_by, (TEBlastFurnace)te, world, x, y, z);
/*     */       case 27:
/*  67 */         return new GuiCalendar(player);
/*     */       case 28:
/*  69 */         pi = PlayerManagerTFC.getInstance().getPlayerInfoFromPlayer(player);
/*  70 */         return new GuiKnapping(player.field_71071_by, (pi.specialCraftingTypeAlternate == null) ? pi.specialCraftingType : null, world, x, y, z);
/*     */       case 29:
/*  72 */         return new GuiChestTFC((IInventory)player.field_71071_by, (IInventory)te, world, x, y, z);
/*     */       case 31:
/*  74 */         return new GuiInventoryTFC(player);
/*     */       
/*     */       case 32:
/*     */       case 33:
/*  78 */         return new GuiQuern(player.field_71071_by, (TEQuern)te, world, x, y, z);
/*     */       case 34:
/*  80 */         return new GuiBlueprint(player, world, x, y, z);
/*     */       case 35:
/*  82 */         return new GuiBarrel(player.field_71071_by, (TEBarrel)te, world, x, y, z, 0);
/*     */       case 36:
/*  84 */         return new GuiBarrel(player.field_71071_by, (TEBarrel)te, world, x, y, z, 1);
/*     */       case 37:
/*  86 */         return new GuiCrucible(player.field_71071_by, (TECrucible)te, world, x, y, z);
/*     */       case 38:
/*  88 */         return new GuiMold(player.field_71071_by, world, x, y, z);
/*     */       case 39:
/*  90 */         return new GuiVessel(player.field_71071_by, world, x, y, z);
/*     */       case 40:
/*  92 */         return new GuiQuiver(player.field_71071_by, world, x, y, z);
/*     */       case 41:
/*  94 */         return new GuiNestBox(player.field_71071_by, (TENestBox)te, world, x, y, z);
/*     */       
/*     */       case 42:
/*  97 */         if (player.field_70154_o instanceof EntityHorseTFC) {
/*     */           
/*  99 */           EntityHorseTFC horse = (EntityHorseTFC)player.field_70154_o;
/* 100 */           horse.updateChestSaddle();
/* 101 */           return new GuiScreenHorseInventoryTFC(player.field_71071_by, (IInventory)horse.getHorseChest(), horse);
/*     */         } 
/*     */         
/* 104 */         return null;
/*     */       
/*     */       case 43:
/* 107 */         return new GuiGrill(player.field_71071_by, (TEGrill)te, world, x, y, z);
/*     */       case 44:
/* 109 */         return new GuiFoodPrep(player.field_71071_by, (TEFoodPrep)te, world, x, y, z, 0);
/*     */       case 45:
/* 111 */         return new GuiFoodPrep(player.field_71071_by, (TEFoodPrep)te, world, x, y, z, 1);
/*     */       case 46:
/* 113 */         return new GuiLargeVessel(player.field_71071_by, (TEVessel)te, world, x, y, z, 0);
/*     */       case 47:
/* 115 */         return new GuiLargeVessel(player.field_71071_by, (TEVessel)te, world, x, y, z, 1);
/*     */       case 48:
/* 117 */         return new GuiCustomNametag(player, world, x, y, z);
/*     */       
/*     */       case 49:
/* 120 */         return new GuiHopper(player.field_71071_by, (TEHopper)te, world, x, y, z);
/*     */     } 
/*     */     
/* 123 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SubscribeEvent
/*     */   public void openGuiHandler(GuiOpenEvent event) {
/* 130 */     if (event.gui instanceof net.minecraft.client.gui.inventory.GuiInventory && !(event.gui instanceof GuiInventoryTFC))
/* 131 */       event.gui = (GuiScreen)new GuiInventoryTFC((EntityPlayer)(Minecraft.func_71410_x()).field_71439_g); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Handlers\Client\GuiHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
/*     */ package com.bioxx.tfc.Core.Player;
/*     */ 
/*     */ import com.bioxx.tfc.Core.TFC_Core;
/*     */ import com.bioxx.tfc.Handlers.Network.AbstractPacket;
/*     */ import com.bioxx.tfc.Handlers.Network.PlayerUpdatePacket;
/*     */ import com.bioxx.tfc.TerraFirmaCraft;
/*     */ import com.bioxx.tfc.api.Events.GetSkillMultiplierEvent;
/*     */ import com.bioxx.tfc.api.Events.PlayerSkillEvent;
/*     */ import com.bioxx.tfc.api.SkillsManager;
/*     */ import cpw.mods.fml.common.eventhandler.Event;
/*     */ import cpw.mods.fml.common.network.ByteBufUtils;
/*     */ import io.netty.buffer.ByteBuf;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraftforge.common.MinecraftForge;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SkillStats
/*     */ {
/*     */   private Map<SkillsManager.Skill, Integer> skillsMap;
/*     */   private EntityPlayer player;
/*     */   
/*     */   public SkillStats(EntityPlayer p) {
/*  32 */     this.player = p;
/*  33 */     this.skillsMap = new HashMap<SkillsManager.Skill, Integer>();
/*  34 */     for (SkillsManager.Skill s : SkillsManager.instance.getSkillsArray())
/*     */     {
/*  36 */       setSkill(s.skillName, 0);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[] getSkillsKeysArray() {
/*  42 */     return this.skillsMap.keySet().toArray();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setSkill(String skillName, int amount) {
/*  47 */     SkillsManager.Skill sk = SkillsManager.instance.getSkill(skillName);
/*  48 */     if (sk != null) {
/*  49 */       this.skillsMap.put(sk, Integer.valueOf(amount));
/*     */     }
/*     */   }
/*     */   
/*     */   public void setSkillSave(String skillName, int amount) {
/*  54 */     SkillsManager.Skill sk = SkillsManager.instance.getSkill(skillName);
/*  55 */     if (sk != null)
/*  56 */       this.skillsMap.put(sk, Integer.valueOf(amount)); 
/*  57 */     writeNBT(this.player.getEntityData());
/*     */   }
/*     */ 
/*     */   
/*     */   public void increaseSkill(String skillName, int amount) {
/*  62 */     SkillsManager.Skill sk = SkillsManager.instance.getSkill(skillName);
/*  63 */     PlayerSkillEvent.Increase event = new PlayerSkillEvent.Increase(this.player, skillName, amount);
/*  64 */     if (!MinecraftForge.EVENT_BUS.post((Event)event))
/*     */     {
/*  66 */       if (this.skillsMap.containsKey(sk)) {
/*     */ 
/*     */         
/*  69 */         int j = ((Integer)this.skillsMap.get(sk)).intValue();
/*     */         
/*  71 */         this.skillsMap.put(sk, Integer.valueOf(j + amount));
/*     */       }
/*     */       else {
/*     */         
/*  75 */         this.skillsMap.put(sk, Integer.valueOf(amount));
/*     */       } 
/*     */     }
/*     */     
/*  79 */     int i = ((Integer)this.skillsMap.get(sk)).intValue();
/*  80 */     if (this.player instanceof EntityPlayerMP) {
/*     */       
/*  82 */       PlayerUpdatePacket playerUpdatePacket = new PlayerUpdatePacket(1, skillName, i);
/*  83 */       TerraFirmaCraft.PACKET_PIPELINE.sendTo((AbstractPacket)playerUpdatePacket, (EntityPlayerMP)this.player);
/*     */     } 
/*  85 */     writeNBT(this.player.getEntityData());
/*     */   }
/*     */ 
/*     */   
/*     */   public int getSkillRaw(String skillName) {
/*  90 */     SkillsManager.Skill sk = SkillsManager.instance.getSkill(skillName);
/*  91 */     if (this.skillsMap.containsKey(sk)) {
/*  92 */       return ((Integer)this.skillsMap.get(sk)).intValue();
/*     */     }
/*  94 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public SkillRank getSkillRank(String skillName) {
/*  99 */     float raw = getSkillMultiplier(skillName);
/* 100 */     if (raw < 0.25D)
/*     */     {
/* 102 */       return SkillRank.Novice;
/*     */     }
/* 104 */     if (raw < 0.5D)
/*     */     {
/* 106 */       return SkillRank.Adept;
/*     */     }
/* 108 */     if (raw < 0.75D)
/*     */     {
/* 110 */       return SkillRank.Expert;
/*     */     }
/*     */ 
/*     */     
/* 114 */     return SkillRank.Master;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getPercToNextRank(String skillName) {
/* 120 */     float raw = getSkillMultiplier(skillName);
/* 121 */     if (raw < 0.25D)
/*     */     {
/* 123 */       return raw / 0.25F;
/*     */     }
/* 125 */     if (raw < 0.5D)
/*     */     {
/* 127 */       return (raw - 0.25F) / 0.25F;
/*     */     }
/* 129 */     if (raw < 0.75D)
/*     */     {
/* 131 */       return (raw - 0.5F) / 0.25F;
/*     */     }
/*     */ 
/*     */     
/* 135 */     return (raw - 0.75F) / 0.25F;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getSkillMultiplier(String skillName) {
/* 141 */     int skill = getSkillRaw(skillName);
/* 142 */     SkillsManager.Skill sk = SkillsManager.instance.getSkill(skillName);
/* 143 */     float mult = getSkillMult(skill, sk.skillRate);
/* 144 */     GetSkillMultiplierEvent event = new GetSkillMultiplierEvent(this.player, skillName, mult);
/* 145 */     MinecraftForge.EVENT_BUS.post((Event)event);
/* 146 */     return event.skillResult;
/*     */   }
/*     */ 
/*     */   
/*     */   private float getSkillMult(int skill, float rate) {
/* 151 */     return 1.0F - rate / (rate + skill);
/*     */   }
/*     */ 
/*     */   
/*     */   public void readNBT(NBTTagCompound nbt) {
/* 156 */     if (nbt.func_74764_b("skillCompound")) {
/*     */       
/* 158 */       NBTTagCompound skillCompound = nbt.func_74775_l("skillCompound");
/* 159 */       for (Object n : skillCompound.func_150296_c()) {
/*     */         
/* 161 */         String skill = (String)n;
/* 162 */         setSkill(skill, skillCompound.func_74762_e(skill));
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeNBT(NBTTagCompound nbt) {
/* 172 */     NBTTagCompound skillCompound = new NBTTagCompound();
/* 173 */     Object[] keys = this.skillsMap.keySet().toArray();
/* 174 */     for (Object o : keys) {
/*     */       
/* 176 */       SkillsManager.Skill k = (SkillsManager.Skill)o;
/* 177 */       int f = ((Integer)this.skillsMap.get(k)).intValue();
/* 178 */       skillCompound.func_74768_a(k.skillName, f);
/*     */     } 
/* 180 */     nbt.func_74782_a("skillCompound", (NBTBase)skillCompound);
/*     */   }
/*     */ 
/*     */   
/*     */   public void toOutBuffer(ByteBuf buffer) {
/* 185 */     Object[] keys = this.skillsMap.keySet().toArray();
/* 186 */     buffer.writeInt(keys.length);
/* 187 */     for (Object o : keys) {
/*     */       
/* 189 */       SkillsManager.Skill k = (SkillsManager.Skill)o;
/* 190 */       int f = ((Integer)this.skillsMap.get(k)).intValue();
/* 191 */       ByteBufUtils.writeUTF8String(buffer, k.skillName);
/* 192 */       buffer.writeInt(f);
/*     */     } 
/*     */   }
/*     */   
/*     */   public enum SkillRank
/*     */   {
/* 198 */     Novice("gui.skill.novice"), Adept("gui.skill.adept"), Expert("gui.skill.expert"), Master("gui.skill.master");
/*     */     
/*     */     String name;
/*     */     
/*     */     SkillRank(String local) {
/* 203 */       this.name = local;
/*     */     }
/*     */ 
/*     */     
/*     */     public String getUnlocalizedName() {
/* 208 */       return this.name;
/*     */     }
/*     */ 
/*     */     
/*     */     public String getLocalizedName() {
/* 213 */       return TFC_Core.translate(this.name);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tencent Files\1347803543\FileRecv\Moegcraft3.3.2.0-Pre1更新包,请删除原先所有文件夹后拖入\mods\[1.7.10]TerraFirmaCraft-0.79.36-TFR-v2.jar!\com\bioxx\tfc\Core\Player\SkillStats.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
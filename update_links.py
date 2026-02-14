import requests

# قائمة القنوات التي تريد تحديثها
# يمكنك إضافة أي عدد من القنوات هنا بنفس التنسيق
channels = [
    {"name": "beIN Sports 1", "id": "116903", "cat": "4524"},
    {"name": "beIN Sports 2", "id": "116904", "cat": "4524"},
]

def generate_m3u8():
    m3u8_content = "#EXTM3U\n#EXT-X-VERSION:6\n"
    
    for ch in channels:
        # الرابط الأساسي الذي سيعمل في تطبيقك
        base_url = f"https://on-tv.site/api/MN2.php?action=stream&id={ch['id']}&cat={ch['cat']}"
        
        # إضافة الهيدرز (User-Agent و Referer) بعد علامة | ليفهمها تطبيق الأندرويد الخاص بك
        full_line = f"{base_url}|userAgent=Mozilla/5.0 (Windows NT 10.0; Win64; x64)|referer=https://on-tv.site/"
        
        m3u8_content += f"\n#EXTINF:-1,{ch['name']}\n{full_line}\n"
    
    # حفظ النتيجة في ملف m3u8
    with open("bein_1.m3u8", "w", encoding="utf-8") as f:
        f.write(m3u8_content)
    print("تم تحديث الملف بنجاح!")

if __name__ == "__main__":
    generate_m3u8()

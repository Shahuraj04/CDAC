namespace MVCDemo
{
    public class Program
    {
        public static void Main(string[] args)
        {
            var builder = WebApplication.CreateBuilder(args);

            // --- SECTION 1: ADD SERVICES (The Ingredients) ---
            // Everything starting with builder.Services MUST be here

            builder.Services.AddControllersWithViews();
            builder.Services.AddSession();

            // FIX: Moved AddCors ABOVE builder.Build()
            builder.Services.AddCors(options =>
            {
                options.AddDefaultPolicy(policy =>
                {
                    policy.AllowAnyOrigin()
                          .AllowAnyMethod()
                          .AllowAnyHeader();
                });
            });

            // --- SECTION 2: BUILD THE APP ---
            var app = builder.Build();

            // --- SECTION 3: CONFIGURE MIDDLEWARE (The Pipeline) ---
            // From here on, you use 'app', not 'builder'

            if (!app.Environment.IsDevelopment())
            {
                app.UseExceptionHandler("/Home/Error");
            }

            app.UseStaticFiles();
            app.UseRouting();

            // FIX: UseCors should usually be between UseRouting and UseAuthorization
            app.UseCors();

            app.UseSession();
            app.UseAuthorization();

            app.MapControllerRoute(
                name: "default",
                pattern: "{controller=Home}/{action=Index}/{id?}");

            app.Run();
        }
    }
}
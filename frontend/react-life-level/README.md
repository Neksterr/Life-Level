# Life Level (React)

## How To Structure React Projects From Beginner To Advanced

July 11, 2022

### Category
- React
- Technical Discussion

React is intentionally unopinionated, so folder structure becomes the guardrail for maintainability. This README explains three levels of src-based structure (simple, intermediate, advanced), and maps the final advanced layout to this repo's style.

---

## Preface

- The examples here only cover the `src/` folders.
- Outside `src/`, project-level files (e.g. `public/`, Webpack/Vite config, test setup) vary by ecosystem.
- Keep it consistent, predictable, and suited to team size.

---

## 1 Simple Folder Structure (good for < 10–15 components)

### Typical layout in `src/`
- `components/`
- `hooks/`
- `__tests__/` (or colocated `*.test.tsx`)
- `App.tsx`
- `index.tsx`

### Principles
- All UI components in one place.
- All custom hooks in one place.
- Minimal enforced boundaries.

### Pros
- Very easy to start.
- Great for prototypes and small apps.

### Cons
- Grows messy quickly.
- No explicit place for images, utils, context, or feature code.

---

## 2 Intermediate Folder Structure (scale-safe, page-centric)

### Typical layout in `src/`
- `assets/`
- `components/` (e.g., `ui/`, `form/`)
- `context/`
- `data/`
- `hooks/` (global/shared hooks)
- `pages/`
- `utils/`
- `App.tsx`
- `index.tsx`

### Notes
- `pages/` holds page-scoped folders and logic.
- Page-specific hooks and components are inside pages.
- Shared items remain in global folders.

### Pros
- Collocates route-level code.
- Root `src/` is mostly high-level folders.
- Testing via colocated `*.test.*` improves traceability.

### Cons
- Page boundaries break when logic is reused across pages.
- Moving shared logic can require refactor to `components/hooks`.

---

## 3 Advanced Folder Structure (feature-centric, large apps)

### Target layout in `src/`
- `features/` (by feature, each with subfolders and an index API)
- `pages/` (thin pages that combine features)
- `layouts/`
- `components/` (generic UI controls)
- `lib/` (facades for external libs, e.g. axios wrappers)
- `services/` (API calls and backend interfaces)
- `hooks/` (cross-feature hooks)
- `context/` (app-wide context providers)
- `utils/`
- `assets/`
- `data/`

### Features folder pattern
- `features/<feature>/` contains the feature’s own:
  - `components/`
  - `hooks/`
  - `context/` (if needed)
  - `services/` or `api/`
  - `utils/`
  - `index.ts` (public exports only)

### Example import guard
- Enforce via ESLint:
  - `no-restricted-imports` from non-index paths:
\`\`\`json
{
  "rules": {
    "no-restricted-imports": ["error", {"patterns": ["@/features/*/*"]}]
  }
}
\`\`\`

### Paths for aliases
- `tsconfig.json` / `jsconfig.json`:
\`\`\`json
{
  "compilerOptions": {
    "baseUrl": ".",
    "paths": {
      "@features/*": ["src/features/*"],
      "@components/*": ["src/components/*"],
      "@lib/*": ["src/lib/*"]
    }
  }
}
\`\`\`

### Pages in this model
- `pages/` is thin and mostly assembles feature exports.
- Feature business logic stays inside `features/`.

### Layouts, lib, services
- `layouts/` for app scaffolding components (sidebar, navbar, etc.)
- `lib/` wraps third-party behavior (e.g., API client, date utilities)
- `services/` holds concrete backend clients and data interaction patterns.

### Pros
- Features are bounded and composition-friendly.
- Clean global public APIs via `features/<n>/index.ts`.
- Easier to scale and keep private internals private.

### Cons
- More folders and learning curve.
- Can be overkill for tiny apps.

---

## How this Repo Maps to Advanced Structure

This project is built with Create React App + TypeScript and currently includes:
- `src/App.tsx`
- `src/index.tsx`
- `src/App.css`, `src/index.css`

### Recommended future expansion for this design
- Add `src/features/` for vertical domain modules.
- Add `src/pages/` for route containers.
- Add `src/components/ui/`, `src/hooks/`, `src/lib/`, `src/services/`.

> Keep small apps simple but keep the advanced layout in mind while growing.

---

## Quick start (existing folder)

1. `npm install`
2. `npm start`
3. `npm test`

---

## Contributing

- Follow existing folder patterns.
- Declare new features in `src/features/` with a private API in `index.ts`.
- Keep `src/pages/` light and declarative.

---

## Conclusion

- Use simple structure for prototypes.
- Adopt intermediate structure when you hit cross-page reuse.
- Use advanced feature structure for larger, long-lived apps.
- Good architecture avoids folders that outgrow one another.
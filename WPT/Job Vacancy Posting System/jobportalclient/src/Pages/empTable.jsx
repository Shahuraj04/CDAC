import React from "react";
import "bootstrap/dist/css/bootstrap.min.css";

import {
  Disclosure,
  DisclosureButton,
  DisclosurePanel,
  Menu,
  MenuButton,
  MenuItem,
  MenuItems,
} from "@headlessui/react";

import { Bars3Icon, BellIcon, XMarkIcon } from "@heroicons/react/24/outline";

const navigation = [
  { name: "Dashboard", href: "#", current: true },
  { name: "Jobs", href: "#", current: false },
  { name: "Applications", href: "#", current: false },
  { name: "Employees", href: "#", current: false },
];

function classNames(...classes) {
  return classes.filter(Boolean).join(" ");
}

export default function EmpTable() {
  return (
    <>
      <Disclosure
        as="nav"
        className="relative bg-gray-800 after:pointer-events-none after:absolute after:inset-x-0 after:bottom-0 after:h-px after:bg-white/10"
      >
        <div className="mx-auto max-w-7xl px-2 sm:px-6 lg:px-8">
          <div className="relative flex h-16 items-center justify-between">
            
            {/* Mobile Toggle Button */}
            <div className="absolute inset-y-0 left-0 flex items-center sm:hidden">
              <DisclosureButton className="group inline-flex items-center justify-center rounded-md p-2 text-gray-400 hover:bg-gray-700 hover:text-white">
                <Bars3Icon className="block size-6 group-data-open:hidden" />
                <XMarkIcon className="hidden size-6 group-data-open:block" />
              </DisclosureButton>
            </div>

            {/* Logo + Links */}
            <div className="flex flex-1 items-center justify-center sm:items-stretch sm:justify-start">
              <div className="flex shrink-0 items-center">
                <img
                  alt="Company Logo"
                  src="https://tailwindcss.com/plus-assets/img/logos/mark.svg"
                  className="h-8 w-auto"
                />
              </div>
              <div className="hidden sm:ml-6 sm:block">
                <div className="flex space-x-4">
                  {navigation.map((item) => (
                    <a
                      key={item.name}
                      href={item.href}
                      className={classNames(
                        item.current
                          ? "bg-gray-900 text-white"
                          : "text-gray-300 hover:bg-gray-700 hover:text-white",
                        "rounded-md px-3 py-2 text-sm font-medium"
                      )}
                      aria-current={item.current ? "page" : undefined}
                    >
                      {item.name}
                    </a>
                  ))}
                </div>
              </div>
            </div>

            {/* Right Side Icons */}
            <div className="absolute inset-y-0 right-0 flex items-center pr-2 sm:static">

              <button className="rounded-full p-1 text-gray-400 hover:text-white">
                <BellIcon className="size-6" />
              </button>

              {/* Profile Dropdown */}
              <Menu as="div" className="relative ml-3">
                <MenuButton className="rounded-full focus:outline-none">
                  <img
                    alt="User"
                    src="https://images.unsplash.com/photo-1472099645785-5658abf4ff4e"
                    className="size-8 rounded-full"
                  />
                </MenuButton>

                <MenuItems className="absolute right-0 mt-2 w-48 rounded-md bg-gray-800 shadow-lg">
                  <MenuItem>
                    <a className="block px-4 py-2 text-sm text-gray-300 hover:bg-gray-700">
                      Profile
                    </a>
                  </MenuItem>
                  <MenuItem>
                    <a className="block px-4 py-2 text-sm text-gray-300 hover:bg-gray-700">
                      Settings
                    </a>
                  </MenuItem>
                  <MenuItem>
                    <a className="block px-4 py-2 text-sm text-gray-300 hover:bg-gray-700">
                      Logout
                    </a>
                  </MenuItem>
                </MenuItems>
              </Menu>
            </div>
          </div>
        </div>

        {/* Mobile Menu */}
        <DisclosurePanel className="sm:hidden">
          <div className="space-y-1 px-2 pt-2 pb-3">
            {navigation.map((item) => (
              <DisclosureButton
                key={item.name}
                as="a"
                href={item.href}
                className={classNames(
                  item.current
                    ? "bg-gray-900 text-white"
                    : "text-gray-300 hover:bg-gray-700 hover:text-white",
                  "block rounded-md px-3 py-2 text-base font-medium"
                )}
              >
                {item.name}
              </DisclosureButton>
            ))}
          </div>
        </DisclosurePanel>
      </Disclosure>

      {/* Page Content */}
      <div className="p-6 mt-6">
        <h2 className="text-2xl font-bold">Employee Table</h2>
      </div>
    </>
  );
}
